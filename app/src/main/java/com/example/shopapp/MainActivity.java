package com.example.shopapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Declaration of all the buttons
    private Button Milk, Sugar, Bread, Flour,Grandtotal,Discount,Nettotal;
    //Declaration of milk textviews
    private TextView milkP,milkVat,milkActualprice;
    //Declaration of sugar textviews
    private TextView sugarP,sugarVat,sugarActualprice;

    //Declaration of bread textviews
    private TextView breadP,breadVat,breadActualprice;

    //Declaration of flour textviews
    private TextView flourP,flourVat,flourActualprice;

   // Declaration of Total, discount,net pay
    private TextView grandtotal, discount, netPay;

    private float Milkprice = 0;
    private float Milkvat = 0;
    private float Milkactualprice = 0;

    private float Sugarprice = 0;
    private float Sugarvat = 0;
    private float Sugaractualprice = 0;

    private float Breadprice = 0;
    private float Breadvat = 0;
    private float Breadactualprice = 0;


    private float Flourprice = 0;
    private float Flourvat = 0;
    private float Flouractualprice = 0;

    //This variable store the result of the actual price of the items after a calculation is performed
    private float itemPrice = 0;

    //Number of counts of each item
   private int milkNumber, sugarNumber, breadNumber, flourNumber;

    private float total = 0;
    private float discountT = 0;
    private float netP = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //BUTTONS
        Milk = findViewById(R.id.milkBtn);
        Sugar = findViewById(R.id.sugarBtn);
        Bread = findViewById(R.id.breadBtn);
        Flour = findViewById(R.id.flourBtn);



        //MILK TEXTVIEWS
        milkP= findViewById(R.id.milkP);
        milkVat = findViewById(R.id.milkvat);
        milkActualprice = findViewById(R.id.milkactualprice);

        //SUGAR TEXTVIEWS
        sugarP= findViewById(R.id.sugarP);
        sugarVat = findViewById(R.id.sugarvat);
        sugarActualprice = findViewById(R.id.sugaractualprice);


        //BREAD TEXTVIEWS
        breadP=findViewById(R.id.breadP);
        breadVat = findViewById(R.id.breadvat);
        breadActualprice = findViewById(R.id.breadactualprice);

        //FLOUR TEXTVIEWS
        flourP=findViewById(R.id.flourP);
        flourVat = findViewById(R.id.flourvat);
        flourActualprice = findViewById(R.id.flouractualprice);


        //PRICE INITIALISAZION
        Milkprice=580;
        Sugarprice=240;
        Breadprice=120;
        Flourprice=420;

//MILK PRICE CALCULATIONS
        Milk.setOnClickListener(view ->{
            if(milkNumber<4){
                milkNumber++;
                itemPrice = (Milkprice * milkNumber);
                Milkvat = (float) (itemPrice * 0.16);
                Milkactualprice = (itemPrice + Milkvat);
                milkP.setText(String.valueOf(Milkactualprice));
                milkVat.setText(String.valueOf(Milkvat));
                milkActualprice.setText(String.valueOf(Milkactualprice));
            }
            else{
                Toast.makeText(this, "You can't buy more than 4", Toast.LENGTH_SHORT).show();
            }
        });

//SUGAR PRICE CALCULATIONS
        Sugar.setOnClickListener(view ->{
            if(sugarNumber<4){
                sugarNumber++;
                itemPrice =( Sugarprice* sugarNumber);
                Sugarvat = (float) (itemPrice * 0.16);
                Sugaractualprice = (itemPrice + Sugarvat);
                sugarP.setText(String.valueOf(Sugaractualprice));
                sugarVat.setText(String.valueOf(Sugarvat));
                sugarActualprice.setText(String.valueOf(Sugaractualprice));
            }
            else{
                Toast.makeText(this, "You can't buy more than 4", Toast.LENGTH_SHORT).show();
            }
                }

        );

//BREAD PRICE CALCULATIONS
        Bread.setOnClickListener(view ->{
            if(breadNumber<4){
                breadNumber++;
                itemPrice = (Breadprice * breadNumber);
                Breadvat = (float) (itemPrice * 0.16);
                Breadactualprice = (itemPrice + Breadvat);
                breadP.setText(String.valueOf(Breadactualprice));
                breadVat.setText(String.valueOf(Breadvat));
                breadActualprice.setText(String.valueOf(Breadactualprice));
            }
            else{
                Toast.makeText(this, "You can't buy more than 4", Toast.LENGTH_SHORT).show();
            }
                }

        );

//FLOUR PRICE CALCULATIONS
        Flour.setOnClickListener(view ->{
            if(flourNumber<4){
                flourNumber++;
                itemPrice = (Flourprice * flourNumber);
                Flourvat = (float) (itemPrice * 0.16);
                Flouractualprice = (itemPrice + Flourvat);
                flourP.setText(String.valueOf(Flouractualprice));
                flourVat.setText(String.valueOf(Flourvat));
                flourActualprice.setText(String.valueOf(Flouractualprice));
            }
            else{
                Toast.makeText(this, "You can't buy more than 4", Toast.LENGTH_SHORT).show();
            }
                });
      // Buttons for total, discount and net pay
        Grandtotal= findViewById(R.id.grandBtn);
        Discount= findViewById(R.id.discountBtn);
        Nettotal= findViewById(R.id.netBtn);

        //Textviews for total, discount and net pay
        grandtotal= findViewById(R.id.grandtotalprice);
        discount= findViewById(R.id.totalDiscount);
        netPay= findViewById(R.id.nettotalprice);

//GRAND TOTAL CALCULATIONS
        Grandtotal.setOnClickListener(
                view -> {
                    total = (Milkactualprice + Sugaractualprice + Breadactualprice + Flouractualprice);
                    grandtotal.setText(String.valueOf(total));
                }
        );

//DISCOUNT CALCULATIONS
        Discount.setOnClickListener(
                view -> {
                    if(total>1000){
                        discountT = (float) (total * 0.15);
                        discount.setText(String.valueOf(discountT));
                    }
                    else{
                        Toast.makeText(this, "You can't get discount", Toast.LENGTH_SHORT).show();
                    }
                }
        );

//NET PAY CALCULATIONS
        Nettotal.setOnClickListener(
                view -> {
                    netP = total - discountT;
                    netPay.setText(String.valueOf(netP));
                }
        );




    }
}