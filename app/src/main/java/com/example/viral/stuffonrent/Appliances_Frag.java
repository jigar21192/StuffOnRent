package com.example.viral.stuffonrent;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Packages_Frag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Packages_Frag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Appliances_Frag extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView rec_appliances;
    Item_Adapter adapter;
    Context context;
    List<Model_item>list;
    String image1,image2,image3,a_name,a_rent,a_company_name,a_city,a_description,a_contact;
    String URL="https://chauhanviral36.000webhostapp.com/getdata_appliances.php";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Appliances_Frag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Packages_Frag.
     */
    // TODO: Rename and change types and number of parameters
    public static Packages_Frag newInstance(String param1, String param2) {
        Packages_Frag fragment = new Packages_Frag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_appliances, container, false);
        list=new ArrayList<>();

        rec_appliances=view.findViewById(R.id.rec_appliances);

        StringRequest request=new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try {
                    JSONArray array=new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject obj = array.getJSONObject(i);

                        image1=obj.getString("image1");
                        image2=obj.getString("image2");
                        image3=obj.getString("image3");
                        a_name=obj.getString("a_name");
                        a_rent=obj.getString("a_rent");
                        a_company_name=obj.getString("a_company_name");
                        a_contact=obj.getString("mobile_number");
                        a_city=obj.getString("a_city");
                        a_description=obj.getString("a_description");

                        Model_item model=new Model_item();
                        model.setImage1(image1);
                        model.setImage2(image2);
                        model.setImage3(image3);
                        model.setA_name(a_name);
                        model.setA_rent(a_rent);
                        model.setA_company_name(a_company_name);
                        model.setContact(a_contact);
                        model.setA_city(a_city);
                        model.setA_description(a_description);
                        model.setTag("appl");

                        list.add(model);

                    }

                    adapter = new Item_Adapter(list,context);
                    rec_appliances.setHasFixedSize(true);
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
                    rec_appliances.setLayoutManager(mLayoutManager);
                    rec_appliances.addItemDecoration(new DividerItemDecoration(context, LinearLayoutManager.VERTICAL));
                    rec_appliances.setAdapter(adapter);
                    onclick();
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue queue= Volley.newRequestQueue(context);
        queue.add(request);

        return view;

    }

    private void onclick() {
        rec_appliances.addOnItemTouchListener(new RV_Click(getActivity(),
                rec_appliances, new ClickListener() {
            @Override
            public void onClick(View view, final int position) {
                Intent intent=new Intent(context,DisplayAppli.class);
                intent.putExtra("image1",list.get(position).getImage1());
                intent.putExtra("image2",list.get(position).getImage2());
                intent.putExtra("image3",list.get(position).getImage3());
                intent.putExtra("a_name",list.get(position).getA_name());
                intent.putExtra("a_rent",list.get(position).getA_rent());
                intent.putExtra("a_company_name",list.get(position).getA_company_name());
                intent.putExtra("a_city",list.get(position).getA_city());
                intent.putExtra("mobile_number",list.get(position).getContact());
                intent.putExtra("a_description",list.get(position).getA_description());
                context.startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(getActivity(), "Long press on position :"+position,
                        Toast.LENGTH_LONG).show();
            }
        }));
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}