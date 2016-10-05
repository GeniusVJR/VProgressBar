package com.francis.vprogressbar;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.francis.vprogressbar.view.HorizontalProgressbarWithProgress;

public class MainActivity extends AppCompatActivity {

	private HorizontalProgressbarWithProgress mHorizontalProgressbarWithProgress;

	private static final int MSG_IPDATE = 0X110;

	private Handler mHandler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			int progress = mHorizontalProgressbarWithProgress.getProgress();
			mHorizontalProgressbarWithProgress.setProgress(++progress);
			if(progress >= 100){
				mHandler.removeMessages(MSG_IPDATE);
			}

			mHandler.sendEmptyMessageDelayed(MSG_IPDATE, 100);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mHorizontalProgressbarWithProgress = (HorizontalProgressbarWithProgress) findViewById(R.id.id_progress01);
		mHandler.sendEmptyMessage(MSG_IPDATE);
	}
}
