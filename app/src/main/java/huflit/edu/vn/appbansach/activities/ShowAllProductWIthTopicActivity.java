package huflit.edu.vn.appbansach.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import huflit.edu.vn.appbansach.R;
import huflit.edu.vn.appbansach.adapters.ShowAllAdapter;
import huflit.edu.vn.appbansach.models.ShowAllModel;

public class ShowAllProductWIthTopicActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ShowAllAdapter showAllAdapter;
    List<ShowAllModel> showAllModelList;
    FirebaseFirestore firestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_product_with_brand);

        String type =getIntent().getStringExtra("type");

        firestore=FirebaseFirestore.getInstance();

        recyclerView=findViewById(R.id.show_all_rec);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        showAllModelList= new ArrayList<>();
        showAllAdapter= new ShowAllAdapter(this,showAllModelList);
        recyclerView.setAdapter(showAllAdapter);

            if ((type !=null && type.equalsIgnoreCase("vanhoc"))){
            firestore.collection("showAll").whereEqualTo("type","vanhoc")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {

                                    ShowAllModel showAllModel = document.toObject(ShowAllModel.class);
                                    showAllModelList.add(showAllModel);
                                    showAllAdapter.notifyDataSetChanged();
                                }
                            } else {
//                            Toast.makeText(getActivity(),""+task.getException(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        if ((type !=null && type.equalsIgnoreCase("tamly"))){
            firestore.collection("showAll").whereEqualTo("type","tamly")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {

                                    ShowAllModel showAllModel = document.toObject(ShowAllModel.class);
                                    showAllModelList.add(showAllModel);
                                    showAllAdapter.notifyDataSetChanged();
                                }
                            } else {
//                            Toast.makeText(getActivity(),""+task.getException(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        if ((type !=null && type.equalsIgnoreCase("kinhte"))){
            firestore.collection("showAll").whereEqualTo("type","kinhte")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {

                                    ShowAllModel showAllModel = document.toObject(ShowAllModel.class);
                                    showAllModelList.add(showAllModel);
                                    showAllAdapter.notifyDataSetChanged();
                                }
                            } else {
//                            Toast.makeText(getActivity(),""+task.getException(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        if ((type !=null && type.equalsIgnoreCase("ngoaingu"))){
            firestore.collection("showAll").whereEqualTo("type","ngoaingu")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {

                                    ShowAllModel showAllModel = document.toObject(ShowAllModel.class);
                                    showAllModelList.add(showAllModel);
                                    showAllAdapter.notifyDataSetChanged();
                                }
                            } else {
//                            Toast.makeText(getActivity(),""+task.getException(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        if ((type !=null && type.equalsIgnoreCase("khoahoc"))){
            firestore.collection("showAll").whereEqualTo("type","khoahoc")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    ShowAllModel showAllModel = document.toObject(ShowAllModel.class);
                                    showAllModelList.add(showAllModel);
                                    showAllAdapter.notifyDataSetChanged();
                                }
                            } else {
//                            Toast.makeText(getActivity(),""+task.getException(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
//        if ((type !=null && type.equalsIgnoreCase("di"))){
//            firestore.collection("showAll").whereEqualTo("type","di")
//                    .get()
//                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                        @Override
//                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                            if (task.isSuccessful()) {
//                                for (QueryDocumentSnapshot document : task.getResult()) {
//
//                                    ShowAllModel showAllModel = document.toObject(ShowAllModel.class);
//                                    showAllModelList.add(showAllModel);
//                                    showAllAdapter.notifyDataSetChanged();
//
//
//                                }
//
//                            } else {
////                            Toast.makeText(getActivity(),""+task.getException(),Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    });
//        }
//        if ((type !=null && type.equalsIgnoreCase("ck"))){
//            firestore.collection("showAll").whereEqualTo("type","ck")
//                    .get()
//                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                        @Override
//                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                            if (task.isSuccessful()) {
//                                for (QueryDocumentSnapshot document : task.getResult()) {
//
//                                    ShowAllModel showAllModel = document.toObject(ShowAllModel.class);
//                                    showAllModelList.add(showAllModel);
//                                    showAllAdapter.notifyDataSetChanged();
//
//
//                                }
//
//                            } else {
////                            Toast.makeText(getActivity(),""+task.getException(),Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    });
//        }
    }
}