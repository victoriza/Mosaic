package es.moodbox.mosaic;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.ScrollView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

	VideoViewCustom mVideoView;
	ScrollView mScrollView;

	public MainActivityFragment() {}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_main, container, false);
		mScrollView = (ScrollView) v.findViewById(R.id.scrollView);

		mVideoView = (VideoViewCustom) v.findViewById(R.id.mosaic);
		mVideoView.setDimensions(1280*10,720*10);
		return v;
	}

	@Override
	public void onResume() {
		super.onResume();

		MediaController mediaController= new MediaController(getActivity());
		mediaController.setAnchorView(mVideoView);
		String youtubeURL;
		//youtubeURL="rtsp://r2---sn-a5m7zu76.c.youtube.com/Ck0LENy73wIaRAnTmlo5oUgpQhMYESARFEgGUg5yZWNvbW1lbmRhdGlvbnIhAWL2kyn64K6aQtkZVJdTxRoO88HsQjpE1a8d1GxQnGDmDA==/0/0/0/video.3gp";
		youtubeURL="http://tamarabernad.com/test/test.mp4";

		Uri uri=Uri.parse(youtubeURL);
		mVideoView.setMediaController(mediaController);
		mVideoView.setVideoURI(uri);
		mVideoView.start();
	}
}
