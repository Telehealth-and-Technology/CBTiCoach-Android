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


public class AssessmentHistoryListActivity extends BaseABSNHActivity {

	AssessmentStartData cData31b;
	ArrayAdapter<AssessmentQuestionnaireData> aa;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mysleep_assessmenthistorylist);
	}
	
	

	

	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		AssessmentHistoryListActivity.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
	

	

		        
	@Override
	protected void onPause() {
		super.onPause();
	}

	private ListView lv;
		
	@Override
	protected void onResume() {
		cData31b = new AssessmentStartData(this);
				
		// Find the ListView resource. 
	    lv = (ListView) findViewById( R.id.lvISIData );
	    aa = new ArrayAdapter<AssessmentQuestionnaireData>(this, R.layout.sleepdatarow, cData31b.alISIData);
	    lv.setAdapter(aa);
		lv.setEmptyView(findViewById(R.id.tSleepDataEmpty));
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent i = new Intent(AssessmentHistoryListActivity.this, AssessmentViewScoresActivity.class );
				i.putExtra("POS", position);
				AssessmentHistoryListActivity.this.startActivityForResult(i,1);
				AssessmentHistoryListActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});
		
		
		super.onResume();
	}
	
	
	
}