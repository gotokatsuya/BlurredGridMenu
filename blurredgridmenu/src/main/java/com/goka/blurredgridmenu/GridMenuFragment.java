package com.goka.blurredgridmenu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by katsuyagoto on 15/06/04.
 */
public class GridMenuFragment extends Fragment implements AdapterView.OnItemClickListener {

    private static final String KEY_BG_RESOURCE_ID = "key_bg_resource_id";

    public static GridMenuFragment newInstance(int backgroundResourceID) {
        GridMenuFragment gridMenuFragment = new GridMenuFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_BG_RESOURCE_ID, backgroundResourceID);
        gridMenuFragment.setArguments(args);
        return gridMenuFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGridMenuAdapter = new GridMenuAdapter(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_grid_menu, null);
        View backgroundView = view.findViewById(R.id.blurred_view);

        int backgroundResourceID = getArguments().getInt(KEY_BG_RESOURCE_ID, 0);
        backgroundView.setBackgroundResource(backgroundResourceID);

        BlurringView blurringView = (BlurringView) view.findViewById(R.id.blurring_view);
        blurringView.setBlurredView(backgroundView);

        GridView gridView = (GridView) view.findViewById(R.id.menu_grid_view);
        mGridMenuAdapter.addAll(this.mMenus);
        gridView.setAdapter(mGridMenuAdapter);
        gridView.setOnItemClickListener(this);
        return view;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (mOnClickMenuListener == null) {
            throw new IllegalArgumentException("Must implement setOnClickMenuListener");
        } else {
            mOnClickMenuListener.onClickMenu(mMenus.get(i), i);
        }
    }

    public void setupMenu(List<GridMenu> menus) {
        this.mMenus = menus;
    }

    private GridMenuAdapter mGridMenuAdapter;

    private List<GridMenu> mMenus = new ArrayList<>();

    private OnClickMenuListener mOnClickMenuListener;

    public void setOnClickMenuListener(OnClickMenuListener listener) {
        mOnClickMenuListener = listener;
    }

    public interface OnClickMenuListener {

        void onClickMenu(GridMenu gridMenu, int position);
    }

}