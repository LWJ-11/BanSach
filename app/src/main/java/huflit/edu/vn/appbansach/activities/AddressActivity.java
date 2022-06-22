package huflit.edu.vn.appbansach.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import huflit.edu.vn.appbansach.R;
import huflit.edu.vn.appbansach.adapters.AddressAdapter;
import huflit.edu.vn.appbansach.models.AddressModel;
import huflit.edu.vn.appbansach.models.NewProductsModel;
import huflit.edu.vn.appbansach.models.PopularProductsModel;
import huflit.edu.vn.appbansach.models.ShowAllModel;

public class AddressActivity extends AppCompatActivity implements AddressAdapter.SelectedAddress{
    Button addAddress;
    RecyclerView recyclerView;
    private List<AddressModel> addressModelList;
    private AddressAdapter addressAdapter;
    FirebaseFirestore firestore;
    FirebaseAuth auth;

    Button paymentBtn;
    Toolbar toolbar;
    String mAddress = " ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        toolbar = findViewById(R.id.address_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Object obj =getIntent().getSerializableExtra("item");

        firestore=FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();

        recyclerView= findViewById(R.id.address_recycler);

        addressModelList = new ArrayList<>();
        addressAdapter= new AddressAdapter(getApplicationContext(),addressModelList,this);
        recyclerView.setAdapter(addressAdapter);
        paymentBtn=findViewById(R.id.payment_btn);

        firestore.collection("CurrentUser").document(auth.getCurrentUser().getUid())
                .collection("Address").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (DocumentSnapshot doc: task.getResult().getDocuments()) {

                        AddressModel addressModel = doc.toObject(AddressModel.class);

                        addressModelList.add(addressModel);
                        addressAdapter.notifyDataSetChanged();


                    }

                }
            }
        });
        paymentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double amount = 0.0;
                if(obj instanceof NewProductsModel){
                    NewProductsModel newProductsModel=(NewProductsModel) obj;
                    amount = newProductsModel.getPrice();
                }
                if(obj instanceof PopularProductsModel){
                    PopularProductsModel popularProductsModel=(PopularProductsModel) obj;
                    amount = popularProductsModel.getPrice();
                }
                if(obj instanceof ShowAllModel){
                    ShowAllModel showAllModel=(ShowAllModel) obj;
                    amount = showAllModel.getPrice();
                }
                Intent intent= new Intent(AddressActivity.this,PaymentActivity.class);
                intent.putExtra("amount",amount);
                startActivity(intent);
            }
        });
        addAddress=findViewById(R.id.add_address_btn);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        addAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddressActivity.this,AddAddressActivity.class));
            }
        });
    }
    @Override
    public void setAddress(String address) {
        mAddress=address;
    }
}