package com.t2.cbt_i.mysleep;


import java.util.Calendar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.BaseABSNHActivity;


public class CBTi_Activity23c extends BaseABSNHActivity {

	CBTi_Data23c cData23c;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_23c);
		

		// Provider Button 
		((Button)findViewById(R.id.bNextQuestion)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
			}
		});
		
		// CheckBox1 
		((CheckBox)findViewById(R.id.cbISIQ0)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
				if( anyChecked() ) {
					((CheckBox)findViewById(R.id.cbISIQ1)).setChecked(false);
					((CheckBox)findViewById(R.id.cbISIQ2)).setChecked(false);
					((CheckBox)findViewById(R.id.cbISIQ3)).setChecked(false);
					((CheckBox)findViewById(R.id.cbISIQ4)).setChecked(false);
					if( cData23c.iQuestion == 2 ) {
						((Button)findViewById(R.id.bSubmit)).setVisibility(View.VISIBLE);
						((Button)findViewById(R.id.bNextQuestion)).setVisibility(View.GONE);
					}
					else {
						((Button)findViewById(R.id.bSubmit)).setVisibility(View.GONE);
						((Button)findViewById(R.id.bNextQuestion)).setVisibility(View.VISIBLE);
					}
				}
				else {
					((Button)findViewById(R.id.bSubmit)).setVisibility(View.GONE);
					((Button)findViewById(R.id.bNextQuestion)).setVisibility(View.GONE);
				}
			}
		});

		// CheckBox2
		((CheckBox)findViewById(R.id.cbISIQ1)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
				if( anyChecked() ) {
					((CheckBox)findViewById(R.id.cbISIQ0)).setChecked(false);
					((CheckBox)findViewById(R.id.cbISIQ2)).setChecked(false);
					((CheckBox)findViewById(R.id.cbISIQ3)).setChecked(false);
					((CheckBox)findViewById(R.id.cbISIQ4)).setChecked(false);
					if( cData23c.iQuestion == 2 ) {
						((Button)findViewById(R.id.bSubmit)).setVisibility(View.VISIBLE);
						((Button)findViewById(R.id.bNextQuestion)).setVisibility(View.GONE);
					}
					else {
						((Button)findViewById(R.id.bSubmit)).setVisibility(View.GONE);
						((Button)findViewById(R.id.bNextQuestion)).setVisibility(View.VISIBLE);
					}
				}
				else {
					((Button)findViewById(R.id.bSubmit)).setVisibility(View.GONE);
					((Button)findViewById(R.id.bNextQuestion)).setVisibility(View.GONE);
				}
			}
		});

		// CheckBox3
		((CheckBox)findViewById(R.id.cbISIQ2)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
				if( anyChecked() ) {
					((CheckBox)findViewById(R.id.cbISIQ0)).setChecked(false);
					((CheckBox)findViewById(R.id.cbISIQ1)).setChecked(false);
					((CheckBox)findViewById(R.id.cbISIQ3)).setChecked(false);
					((CheckBox)findViewById(R.id.cbISIQ4)).setChecked(false);
					if( cData23c.iQuestion == 2 ) {
						((Button)findViewById(R.id.bSubmit)).setVisibility(View.VISIBLE);
						((Button)findViewById(R.id.bNextQuestion)).setVisibility(View.GONE);
					}
					else {
						((Button)findViewById(R.id.bSubmit)).setVisibility(View.GONE);
						((Button)findViewById(R.id.bNextQuestion)).setVisibility(View.VISIBLE);
					}
				}
				else {
					((Button)findViewById(R.id.bSubmit)).setVisibility(View.GONE);
					((Button)findViewById(R.id.bNextQuestion)).setVisibility(View.GONE);
				}
			}
		});

		// CheckBox4
		((CheckBox)findViewById(R.id.cbISIQ3)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
				if( anyChecked() ) {
					((CheckBox)findViewById(R.id.cbISIQ0)).setChecked(false);
					((CheckBox)findViewById(R.id.cbISIQ1)).setChecked(false);
					((CheckBox)findViewById(R.id.cbISIQ2)).setChecked(false);
					((CheckBox)findViewById(R.id.cbISIQ4)).setChecked(false);
					if( cData23c.iQuestion == 2 ) {
						((Button)findViewById(R.id.bSubmit)).setVisibility(View.VISIBLE);
						((Button)findViewById(R.id.bNextQuestion)).setVisibility(View.GONE);
					}
					else {
						((Button)findViewById(R.id.bSubmit)).setVisibility(View.GONE);
						((Button)findViewById(R.id.bNextQuestion)).setVisibility(View.VISIBLE);
					}
				}
				else {
					((Button)findViewById(R.id.bSubmit)).setVisibility(View.GONE);
					((Button)findViewById(R.id.bNextQuestion)).setVisibility(View.GONE);
				}
			}
		});

		// CheckBox5
		((CheckBox)findViewById(R.id.cbISIQ4)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
				if( anyChecked() ) {
					((CheckBox)findViewById(R.id.cbISIQ0)).setChecked(false);
					((CheckBox)findViewById(R.id.cbISIQ1)).setChecked(false);
					((CheckBox)findViewById(R.id.cbISIQ2)).setChecked(false);
					((CheckBox)findViewById(R.id.cbISIQ3)).setChecked(false);
					if( cData23c.iQuestion == 2 ) {
						((Button)findViewById(R.id.bSubmit)).setVisibility(View.VISIBLE);
						((Button)findViewById(R.id.bNextQuestion)).setVisibility(View.GONE);
					}
					else {
						((Button)findViewById(R.id.bSubmit)).setVisibility(View.GONE);
						((Button)findViewById(R.id.bNextQuestion)).setVisibility(View.VISIBLE);
					}
				}
				else {
					((Button)findViewById(R.id.bSubmit)).setVisibility(View.GONE);
					((Button)findViewById(R.id.bNextQuestion)).setVisibility(View.GONE);
				}
			}
		});



		// Next Question Button 
		((Button)findViewById(R.id.bNextQuestion)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the next button
				cData23c.iScore[cData23c.iQuestion+1] = getScore();
				cData23c.iQuestion++;
				cData23c.b0 = cData23c.b1 = cData23c.b2 = cData23c.b3 = cData23c.b4 = false;
				fetchScreen();
				((Button)findViewById(R.id.bNextQuestion)).setVisibility(View.GONE);
				
			}
		});

		// Submit Button 
		((Button)findViewById(R.id.bSubmit)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the submit button
				((LinearLayout)findViewById(R.id.llISI)).setVisibility(View.GONE);
				cData23c.iScore[cData23c.iQuestion+1] = getScore();
				cData23c.iCumScore = cData23c.iScore[0] + cData23c.iScore[1] + cData23c.iScore[2] + cData23c.iScore[3];
				
				((Button)findViewById(R.id.bSubmit)).setVisibility(View.GONE);
				((Button)findViewById(R.id.bDone)).setVisibility(View.VISIBLE);
				((TextView)findViewById(R.id.tSNQResult)).setVisibility(View.VISIBLE);
				if( !inLast6Days() ) {
					if( cData23c.iCumScore <10 )
						((TextView)findViewById(R.id.tSNQResult)).setText(R.string.s_snq09a);
					else if( cData23c.iCumScore <13 )
						((TextView)findViewById(R.id.tSNQResult)).setText(R.string.s_snq1012a);
					else
						((TextView)findViewById(R.id.tSNQResult)).setText(R.string.s_snq13ga);
					((Button)findViewById(R.id.bAdd15)).setVisibility(View.VISIBLE);
					((Button)findViewById(R.id.bAdd30)).setVisibility(View.VISIBLE);
				} 
				else {
					if( cData23c.iCumScore <10 )
						((TextView)findViewById(R.id.tSNQResult)).setText(R.string.s_snq09b);
					else if( cData23c.iCumScore <13 )
						((TextView)findViewById(R.id.tSNQResult)).setText(R.string.s_snq1012b);
					else
						((TextView)findViewById(R.id.tSNQResult)).setText(R.string.s_snq13gb);
				}
				Calendar cc = Calendar.getInstance();
				cc.set(Calendar.HOUR_OF_DAY, 0);
				cc.set(Calendar.MINUTE, 0 );
				cc.set(Calendar.SECOND, 0 );
				cc.set(Calendar.MILLISECOND, 0 );
				cData23c.lDate = cc.getTimeInMillis();
				cData23c.saveData();
			}
		});
		
		// Done Button 
		((Button)findViewById(R.id.bDone)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the submit button
				CBTi_Data23a cData23a = new CBTi_Data23a(CBTi_Activity23c.this);
				cData23a.bAdd15 = false;
				cData23a.bAdd30 = false;
				cData23a.saveData();
				Intent i = new Intent(CBTi_Activity23c.this, CBTi_Activity20a.class );
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				CBTi_Activity23c.this.startActivity(i);
				CBTi_Activity23c.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
			}
		});
		
		// Add15 Button 
		((Button)findViewById(R.id.bAdd15)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the submit button
				CBTi_Data23a cData23a = new CBTi_Data23a(CBTi_Activity23c.this);
				cData23a.bAdd15 = true;
				cData23a.bAdd30 = false;
				cData23a.saveData();
				Intent i = new Intent(CBTi_Activity23c.this, CBTi_Activity20a.class );
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				CBTi_Activity23c.this.startActivity(i);
				CBTi_Activity23c.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
			}
		});
		
		// Add30 Button 
		((Button)findViewById(R.id.bAdd30)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the submit button
				CBTi_Data23a cData23a = new CBTi_Data23a(CBTi_Activity23c.this);
				cData23a.bAdd30 = true;
				cData23a.bAdd15 = false;
				cData23a.saveData();
				Intent i = new Intent(CBTi_Activity23c.this, CBTi_Activity20a.class );
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				CBTi_Activity23c.this.startActivity(i);
				CBTi_Activity23c.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
			}
		});
	}
	
	private Boolean anyChecked() {
		return ( 	((CheckBox)findViewById(R.id.cbISIQ0)).isChecked() | ((CheckBox)findViewById(R.id.cbISIQ1)).isChecked() |
					((CheckBox)findViewById(R.id.cbISIQ2)).isChecked() | ((CheckBox)findViewById(R.id.cbISIQ3)).isChecked() |
					((CheckBox)findViewById(R.id.cbISIQ4)).isChecked() );
	}
	
	private int getScore() {
		int iScore;
		if( cData23c.iQuestion == 2){
			if( ((CheckBox)findViewById(R.id.cbISIQ0)).isChecked() )
				iScore = 5;
			else if( ((CheckBox)findViewById(R.id.cbISIQ1)).isChecked() )
				iScore = 4;
			else if( ((CheckBox)findViewById(R.id.cbISIQ2)).isChecked() )
				iScore = 3;
			else if( ((CheckBox)findViewById(R.id.cbISIQ3)).isChecked() )
				iScore = 2;
			else
				iScore = 1;
		}
		else {
			if( ((CheckBox)findViewById(R.id.cbISIQ0)).isChecked() )
				iScore = 1;
			else if( ((CheckBox)findViewById(R.id.cbISIQ1)).isChecked() )
				iScore = 2;
			else if( ((CheckBox)findViewById(R.id.cbISIQ2)).isChecked() )
				iScore = 3;
			else if( ((CheckBox)findViewById(R.id.cbISIQ3)).isChecked() )
				iScore = 4;
			else
				iScore = 5;
		}

		return iScore;
	}

	

	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		CBTi_Activity23c.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
	
	
		
	
		        
	@Override
	protected void onPause() {
		cData23c.b0 = ((CheckBox)findViewById(R.id.cbISIQ0)).isChecked();
		cData23c.b1 = ((CheckBox)findViewById(R.id.cbISIQ1)).isChecked();
		cData23c.b2 = ((CheckBox)findViewById(R.id.cbISIQ2)).isChecked();
		cData23c.b3 = ((CheckBox)findViewById(R.id.cbISIQ3)).isChecked();
		cData23c.b4 = ((CheckBox)findViewById(R.id.cbISIQ4)).isChecked();
		cData23c.saveData();			// save data to file
		super.onPause();
	}

	
	private void fetchScreen() {
		// 1 screen for state -1 is ready to go
		if( cData23c.iQuestion == 0 ) { 
			((TextView)findViewById(R.id.tISIQ)).setText( R.string.s_snq2 );
		}
		else if( cData23c.iQuestion == 1 ) { 
			((TextView)findViewById(R.id.tISIQ)).setText( R.string.s_snq3 );
		}
		else if( cData23c.iQuestion == 2 ) { 
			((TextView)findViewById(R.id.tISIQ)).setText( R.string.s_snq4 );
		}
		
		getSupportActionBar().setTitle( String.format(getString(R.string.s_ISITitle), cData23c.iQuestion+2) );
		((CheckBox)findViewById(R.id.cbISIQ0)).setChecked( cData23c.b0 );
		((CheckBox)findViewById(R.id.cbISIQ1)).setChecked( cData23c.b1 );
		((CheckBox)findViewById(R.id.cbISIQ2)).setChecked( cData23c.b2 );
		((CheckBox)findViewById(R.id.cbISIQ3)).setChecked( cData23c.b3 );
		((CheckBox)findViewById(R.id.cbISIQ4)).setChecked( cData23c.b4 );
		
		
	}
	
	@Override
	protected void onResume() {
		cData23c = new CBTi_Data23c(this);
		
		fetchScreen();
		if( anyChecked() ) {
			if( cData23c.iQuestion == 2 ) {
				((Button)findViewById(R.id.bSubmit)).setVisibility(View.VISIBLE);
				((Button)findViewById(R.id.bNextQuestion)).setVisibility(View.GONE);
			}
			else {
				((Button)findViewById(R.id.bSubmit)).setVisibility(View.GONE);
				((Button)findViewById(R.id.bNextQuestion)).setVisibility(View.VISIBLE);
			}
		}
		super.onResume();
	}
	
	private Boolean inLast6Days() {
		if( cData23c.lDate == -1 )
			return false;
		Calendar cc = Calendar.getInstance();
		cc.set(Calendar.HOUR_OF_DAY, 0);
		cc.set(Calendar.MINUTE, 0 );
		cc.set(Calendar.SECOND, 0 );
		cc.set(Calendar.MILLISECOND, 0 );
		int iJulian = cc.get(Calendar.DAY_OF_YEAR);
		cc.set(Calendar.DAY_OF_YEAR, iJulian-6);
		long l6Days = cc.getTimeInMillis();			// 6 days ago
		
		return cData23c.lDate >= l6Days;
	}
}