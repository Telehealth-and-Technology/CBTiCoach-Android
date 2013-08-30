package com.t2.cbt_i.mysleep;




import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.dashboard.CBTi_BaseActivity;
import com.t2.cbt_i.dashboard.DashActivity;


public class CBTi_Activity32f extends CBTi_BaseActivity {

	CBTi_Data31b cData31b;
	ArrayAdapter<CBTi_Data31c> aa;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_32f);
	
		// set up top bar
		((ImageButton)findViewById(R.id.ibTopLeft)).setImageResource(R.drawable.ic_menu_home);
		((TextView)findViewById(R.id.tvTopTitle)).setText( R.string.s_SleepDiary);
		((ImageButton)findViewById(R.id.ibTopRight)).setVisibility(View.INVISIBLE);

		// topLeft Button HOME
		((ImageButton)findViewById(R.id.ibTopLeft)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
				Intent i = new Intent(CBTi_Activity32f.this, DashActivity.class );
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				CBTi_Activity32f.this.startActivity(i);
				CBTi_Activity32f.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
			}
		});
	}
	
	

	

	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		CBTi_Activity32f.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
	

	

		        
	@Override
	protected void onPause() {
		super.onPause();
	}

	private ListView lv;
		
	@Override
	protected void onResume() {
		cData31b = new CBTi_Data31b(this);
				
		// Find the ListView resource. 
	    lv = (ListView) findViewById( R.id.lvISIData );
	    aa = new ArrayAdapter<CBTi_Data31c>(this, R.layout.sleepdatarow, cData31b.alISIData);
	    lv.setAdapter(aa);
		lv.setEmptyView(findViewById(R.id.tSleepDataEmpty));
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent i = new Intent(CBTi_Activity32f.this, CBTi_Activity32f1.class );
				i.putExtra("POS", position);
				CBTi_Activity32f.this.startActivityForResult(i,1);
				CBTi_Activity32f.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});
		
		
		super.onResume();
	}
	
	
	
}