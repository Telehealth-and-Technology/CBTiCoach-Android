package com.t2.cbt_i.mysleep;




import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.BaseABSNHActivity;


public class CBTi_Activity32f extends BaseABSNHActivity {

	CBTi_Data31b cData31b;
	ArrayAdapter<CBTi_Data31c> aa;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_32f);
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