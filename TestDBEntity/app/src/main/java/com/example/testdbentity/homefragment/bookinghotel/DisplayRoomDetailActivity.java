package com.example.testdbentity.homefragment.bookinghotel;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testdbentity.InformationEntity;
import com.example.testdbentity.R;
import com.example.testdbentity.homefragment.bookinghotel.database.BookingHotelViewModel;
import com.example.testdbentity.homefragment.bookinghotel.hotelandpeople.InformationPeopleWithBookingHotel;
import com.example.testdbentity.homefragment.bookinghotel.hotelandpeople.PeopleAndHotelRef;
import com.example.testdbentity.homefragment.bookinghotel.image.roomandimg.RoomWithImage;
import com.example.testdbentity.homefragment.bookinghotel.roomandpeople.PeopleAndRoomRef;

import java.util.ArrayList;
import java.util.List;

public class DisplayRoomDetailActivity extends AppCompatActivity {
    private BookingHotelViewModel bookingHotelViewModel;
    private int idUser;
    private int idRoom;
    private int idHotel;
    private int[] timeFrom;
    private int[] timeTo;
    private List<Integer> listPathImage;
    private String nameRoomDetail;
    private String priceRoomDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_room_detail);
        bookingHotelViewModel = new ViewModelProvider(this).get(BookingHotelViewModel.class);
        getIntentFromDisplayActivityRoom();
        getListDataRoom();
        getListImageRoom();
        setDayBookHotel();
        getNameRoomDetail();
        getPriceRoomDetail();
        onClickSave(idRoom, idHotel);
        onClickBook(idRoom, idHotel);
    }

    private void getIntentFromDisplayActivityRoom() {
        idUser = getIntent().getIntExtra("idInformationUser", 0);
        idRoom = getIntent().getIntExtra("idRoom", 0);
        timeFrom = getIntent().getIntArrayExtra("timeFrom");
        timeTo = getIntent().getIntArrayExtra("timeTo");
    }

    private void getListDataRoom() {
        listPathImage = new ArrayList<>();
        RoomWithImage roomWithImage = bookingHotelViewModel.getAllImageOfRoomWithIdRoom(idRoom);
        listPathImage.add(roomWithImage.imageRooms.get(0).srcImageRoom);
        listPathImage.add(roomWithImage.imageRooms.get(0).srcImageRoom);
        listPathImage.add(roomWithImage.imageRooms.get(0).srcImageRoom);
        listPathImage.add(roomWithImage.imageRooms.get(0).srcImageRoom);

        nameRoomDetail = roomWithImage.bookingRoomEntity.nameBookingRoom;
        BookingHotelEntity bookingHotelEntity = bookingHotelViewModel.getHotelFromForeignKeyRoom(roomWithImage.bookingRoomEntity.fkBookingRoom);
        idHotel = bookingHotelEntity.idBookingHotel;
        nameRoomDetail += ", " + bookingHotelEntity.quanBookingHotel + ", " +bookingHotelEntity.cityBookingHotel;

        priceRoomDetail = String.valueOf(roomWithImage.bookingRoomEntity.priceBookingRoom) + "VND";
    }
    private void getListImageRoom()
    {
        ImageView imageView1 = findViewById(R.id.image_room_detail_1);
        ImageView imageView2 = findViewById(R.id.image_room_detail_2);
        ImageView imageView3 = findViewById(R.id.image_room_detail_3);
        ImageView imageView4 = findViewById(R.id.image_room_detail_4);

        imageView1.setImageResource(listPathImage.get(0));
        imageView2.setImageResource(listPathImage.get(1));
        imageView3.setImageResource(listPathImage.get(2));
        imageView4.setImageResource(listPathImage.get(3));
    }

    private void getNameRoomDetail()
    {
        TextView textView = findViewById(R.id.name_of_room_detail);
        textView.setText(nameRoomDetail);
    }

    private void getPriceRoomDetail()
    {
        TextView textView = findViewById(R.id.price_room_detail);
        textView.setText(priceRoomDetail);
    }
    private void setDayBookHotel()
    {
        TextView startDay = findViewById(R.id.check_in_room_detail);
        TextView endDay = findViewById(R.id.check_out_room_detail);

        String startTime = String.valueOf(timeFrom[0]) + " tháng " + String.valueOf(timeFrom[1]) + " năm " + String.valueOf(timeFrom[2]);
        String endTime = String.valueOf(timeTo[0]) + " tháng " + String.valueOf(timeTo[1]) + " năm " + String.valueOf(timeTo[2]);

        startDay.setText(startTime);
        endDay.setText(endTime);

    }
    private void onClickSave(int idRoom, int idHotel) {
        ImageButton button = findViewById(R.id.button_save_room);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<InformationPeopleWithBookingHotel> informationPeopleWithBookingHotel = bookingHotelViewModel.getAllHotelOfUserWithIdUser(idUser);
                if (informationPeopleWithBookingHotel.size() == 0) {
                    bookingHotelViewModel.insertPeopleAndHotelREF(new PeopleAndHotelRef(idHotel, idUser));
                    bookingHotelViewModel.insertPeopleAndRoomREF(new PeopleAndRoomRef(idRoom, idUser));
                } else {
                    //check hotel xem hotel da duoc book chua. Neu nhu user chua save hotel thi insert hotel and
                    List<InformationPeopleWithBookingHotel> bookingHotelEntity = bookingHotelViewModel.getAllHotelOfUserWithIdUser(idUser);
                    boolean checkbookhotel = false;
                    for (BookingHotelEntity x : bookingHotelEntity.get(0).bookingHotelEntities) {
                        if (x.idBookingHotel == idHotel) {
                            checkbookhotel = true;
                            break;
                        }
                    }
                    if (!checkbookhotel) {
                        bookingHotelViewModel.insertPeopleAndRoomREF(new PeopleAndRoomRef(idRoom, idUser));
                        bookingHotelViewModel.insertPeopleAndHotelREF(new PeopleAndHotelRef(idHotel, idUser));
                    } else {
                        //check room xem book chua

                        List<BookingRoomEntity> bookingRoomEntities = bookingHotelViewModel.getRoomOfUserWithIdHotel(idHotel, idUser);

                        boolean checkbookroom = false;
                        for (BookingRoomEntity x : bookingRoomEntities) {
                            if (x.idBookingRoom == idRoom) {
                                checkbookroom = true;
                                PeopleAndRoomRef peopleAndRoomRef = bookingHotelViewModel.getUserAndRoomREF(idUser, x.idBookingRoom);
                                bookingHotelViewModel.deleteUserAndRoomREF(peopleAndRoomRef);
                                break;
                            }
                        }
                        if (!checkbookroom) {
                            bookingHotelViewModel.insertPeopleAndRoomREF(new PeopleAndRoomRef(idRoom, idUser));
                        }
                        List<InformationPeopleWithBookingHotel> bookingHotelEntity1 = bookingHotelViewModel.getAllHotelOfUserWithIdUser(idUser);

                        for (BookingHotelEntity x : bookingHotelEntity1.get(0).bookingHotelEntities) {
                            List<BookingRoomEntity> bookingRoomEntities1 = bookingHotelViewModel.getRoomOfUserWithIdHotel(x.idBookingHotel, idUser);
                            if (bookingRoomEntities1.size() == 0) {
                                PeopleAndHotelRef peopleAndHotelRef = bookingHotelViewModel.getUserAndHotelREF(idUser, x.idBookingHotel);
                                bookingHotelViewModel.deleteUserAndHotelREF(peopleAndHotelRef);
                            }
                        }
                    }
                }
                Toast.makeText(getApplicationContext(), "Da luu", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void onClickBook(int idRoom, int idHotel)
    {
        Button button = findViewById(R.id.button_book_room);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InformationEntity informationEntity = bookingHotelViewModel.getBookingRoomUser(idUser);
                if (informationEntity.isBookingroom == 1) {
                    Toast.makeText(getApplicationContext(), "Ban da Book phong roi", Toast.LENGTH_SHORT).show();
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(DisplayRoomDetailActivity.this);
                    builder.setMessage("Booking");
                    builder.setTitle("Do you want to booking ?");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {

                        BookingRoomEntity bookingRoomEntity1 = bookingHotelViewModel.getRoomById(idRoom);
                        bookingRoomEntity1.isBookingRoom = 1;
                        bookingRoomEntity1.idUserBookingRoom = idUser;
                        bookingHotelViewModel.updateRoomToBooked(bookingRoomEntity1);
                        informationEntity.isBookingroom = 1;
                        //update la nguoi dung da book phong roi
                        bookingHotelViewModel.updateWasBookingRoomInUser(informationEntity);
                        //nay ra trang thong tin day du ve booking -> hoa don -> tran chu

                        String name = informationEntity.firstNaeInformationUser + informationEntity.lastNaeInformationUser;
                        //trang hoa don book phong se start activity ve home
                        Intent intent = new Intent(DisplayRoomDetailActivity.this, DisplayPaymentHotelActivity.class);
                        intent.putExtra("userId", idUser);
                        intent.putExtra("roomId", idRoom);
                        intent.putExtra("hotelId", idHotel);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "Booking Done!", Toast.LENGTH_SHORT).show();
                    });
                    builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
                        dialog.cancel();
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            };
        });
    }
}