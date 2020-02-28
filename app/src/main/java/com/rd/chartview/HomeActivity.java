package com.rd.chartview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.rd.chartview.view.ChartView;
import com.rd.chartview.view.draw.data.InputData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ac_home);
		initViews();
	}

	private void initViews() {
		ChartView chartView = findViewById(R.id.charView);
		List<InputData> dataList = createChartData();
		chartView.setData(dataList);

		ImageView icGear = findViewById(R.id.ic_gear);
		icGear.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getBaseContext(), RecyclerActivity.class);
				startActivity(i);
			}
		});
	}

	@NonNull
	private List<InputData> createChartData() {
		List<InputData> dataList = new ArrayList<>();
		dataList.add(new InputData(10));
		dataList.add(new InputData(25));
		dataList.add(new InputData(20));
		dataList.add(new InputData(30));
		dataList.add(new InputData(20));
		dataList.add(new InputData(50));
		dataList.add(new InputData(40));

		long currMillis = System.currentTimeMillis();
		currMillis -= currMillis % TimeUnit.DAYS.toMillis(1);

		for (int i = 0; i < dataList.size(); i++) {
			long position = dataList.size() - 1 - i;
			long offsetMillis = TimeUnit.DAYS.toMillis(position);

			long millis = currMillis - offsetMillis;
			dataList.get(i).setMillis(millis);
		}

		return dataList;
	}
}
