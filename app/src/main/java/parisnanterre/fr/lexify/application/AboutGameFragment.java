package parisnanterre.fr.lexify.application;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import parisnanterre.fr.lexify.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AboutGameFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AboutGameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class AboutGameFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    boolean rules_actif = false;

    public AboutGameFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AboutGameFragment.
     */

    // TODO: Rename and change types and number of parameters
    public static AboutGameFragment newInstance(String param1, String param2) {
        AboutGameFragment fragment = new AboutGameFragment();
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
        View view = inflater.inflate(R.layout.fragment_about_game, container, false);
        final Button btn_regles = view.findViewById(R.id.fragment_about_regles_btn);
        final Button btn_about_application = view.findViewById(R.id.fragment_about_application_btn);
        final Button btn_menu = view.findViewById(R.id.fragment_about_menu_btn);
        final TextView txt_about_application = view.findViewById(R.id.fragment_about_affiche_txt);
        final ImageView image_github = view.findViewById(R.id.fragment_about_github);
        final ImageView image_website = view.findViewById(R.id.fragment_about_website);
        final LinearLayout social_media = view.findViewById(R.id.fragment_social_media);

        image_github.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://github.com/LexifyOrganization/Lexify"));
                startActivity(intent);
            }
        });

        image_website.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://lexifyorganization.github.io/Lexify/"));
                startActivity(intent);
            }
        });


        txt_about_application.setText(R.string.aboutapplication);

        btn_menu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MainActivity.class);
                startActivity(i);
            }
        });

        btn_regles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_about_application.setText(getResources().getString(R.string.aboutrules));
                social_media.setVisibility(View.GONE);

            }
        });

        btn_about_application.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_about_application.setText(getResources().getString(R.string.aboutapplication));
                social_media.setVisibility(View.VISIBLE);

            }
        });


        return view;

    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
