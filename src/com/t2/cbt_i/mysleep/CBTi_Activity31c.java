package com.t2.cbt_i.mysleep;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.dashboard.CBTi_BaseActivity;
import com.t2.cbt_i.dashboard.DashActivity;


public class CBTi_Activity31c extends CBTi_BaseActivity {

	CBTi_Data31c cData31c;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_31c);

		// set up top bar
		((ImageButton)findViewById(R.id.ibTopLeft)).setImageResource(R.drawable.ic_menu_home);
		((ImageButton)findViewById(R.id.ibTopRight)).setVisibility(View.INVISIBLE);

		// topLeft Button HOME
		((ImageButton)findViewById(R.id.ibTopLeft)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
				Intent i = new Intent(CBTi_Activity31c.this, DashActivity.class );
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				CBTi_Activity31c.this.startActivity(i);
				CBTi_Activity31c.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
			}
		});
		

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
					if( cData31c.iQuestion == 5 ) {
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
					if( cData31c.iQuestion == 5 ) {
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
					if( cData31c.iQuestion == 5 ) {
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
					if( cData31c.iQuestion == 5 ) {
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
					if( cData31c.iQuestion == 5 ) {
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
				cData31c.iScore[cData31c.iQuestion+1] = getScore();
				cData31c.iQuestion++;
				cData31c.b0 = cData31c.b1 = cData31c.b2 = cData31c.b3 = cData31c.b4 = false;
				fetchScreen();
				((Button)findViewById(R.id.bNextQuestion)).setVisibility(View.GONE);
				
			}
		});

		// Submit Button 
		((Button)findViewById(R.id.bSubmit)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the submit button
				cData31c.iScore[cData31c.iQuestion+1] = getScore();
				cData31c.iCumScore = cData31c.iScore[0] + cData31c.iScore[1] + cData31c.iScore[2] + cData31c.iScore[3] +
							         cData31c.iScore[4] + cData31c.iScore[5] + cData31c.iScore[6];
				CBTi_Data31b cData31b = new CBTi_Data31b(CBTi_Activity31c.this);
				cData31b.addEntry(cData31c);
				cData31b.saveData();
				Intent i = new Intent(CBTi_Activity31c.this, CBTi_Activity31e.class );
				CBTi_Activity31c.this.startActivity(i);
				CBTi_Activity31c.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
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
		if( ((CheckBox)findViewById(R.id.cbISIQ0)).isChecked() )
			iScore = 0;
		else if( ((CheckBox)findViewById(R.id.cbISIQ1)).isChecked() )
			iScore = 1;
		else if( ((CheckBox)findViewById(R.id.cbISIQ2)).isChecked() )
			iScore = 2;
		else if( ((CheckBox)findViewById(R.id.cbISIQ3)).isChecked() )
			iScore = 3;
		else
			iScore = 4;

		return iScore;
	}

	

	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		CBTi_Activity31c.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
	
	
		
	
		        
	@Override
	protected void onPause() {
		cData31c.b0 = ((CheckBox)findViewById(R.id.cbISIQ0)).isChecked();
		cData31c.b1 = ((CheckBox)findViewById(R.id.cbISIQ1)).isChecked();
		cData31c.b2 = ((CheckBox)findViewById(R.id.cbISIQ2)).isChecked();
		cData31c.b3 = ((CheckBox)findViewById(R.id.cbISIQ3)).isChecked();
		cData31c.b4 = ((CheckBox)findViewById(R.id.cbISIQ4)).isChecked();
		cData31c.saveData();			// save data to file
		super.onPause();
	}

	
	private void fetchScreen() {
		// 1 screen for state -1 is ready to go
		if( cData31c.iQuestion == 0 ) { 
			((TextView)findViewById(R.id.tISIQ)).setText( R.string.s_ISIQ2 );
			((TextView)findViewById(R.id.cbISIQ0)).setText( R.string.s_ISIQ10 );
			((TextView)findViewById(R.id.cbISIQ1)).setText( R.string.s_ISIQ11 );
			((TextView)findViewById(R.id.cbISIQ2)).setText( R.string.s_ISIQ12 );
			((TextView)findViewById(R.id.cbISIQ3)).setText( R.string.s_ISIQ13 );
			((TextView)findViewById(R.id.cbISIQ4)).setText( R.string.s_ISIQ14 );
		}
		else if( cData31c.iQuestion == 1 ) { 
			((TextView)findViewById(R.id.tISIQ)).setText( R.string.s_ISIQ3 );
			((TextView)findViewById(R.id.cbISIQ0)).setText( R.string.s_ISIQ10 );
			((TextView)findViewById(R.id.cbISIQ1)).setText( R.string.s_ISIQ11 );
			((TextView)findViewById(R.id.cbISIQ2)).setText( R.string.s_ISIQ12 );
			((TextView)findViewById(R.id.cbISIQ3)).setText( R.string.s_ISIQ13 );
			((TextView)findViewById(R.id.cbISIQ4)).setText( R.string.s_ISIQ14 );
		}
		else if( cData31c.iQuestion == 2 ) { 
			((TextView)findViewById(R.id.tISIQ)).setText( R.string.s_ISIQ4 );
			((TextView)findViewById(R.id.cbISIQ0)).setText( R.string.s_ISIQ40 );
			((TextView)findViewById(R.id.cbISIQ1)).setText( R.string.s_ISIQ41 );
			((TextView)findViewById(R.id.cbISIQ2)).setText( R.string.s_ISIQ42 );
			((TextView)findViewById(R.id.cbISIQ3)).setText( R.string.s_ISIQ43 );
			((TextView)findViewById(R.id.cbISIQ4)).setText( R.string.s_ISIQ44 );
		}
		else if( cData31c.iQuestion == 3 ) { 
			((TextView)findViewById(R.id.tISIQ)).setText( R.string.s_ISIQ5 );
			((TextView)findViewById(R.id.cbISIQ0)).setText( R.string.s_ISIQ50 );
			((TextView)findViewById(R.id.cbISIQ1)).setText( R.string.s_ISIQ51 );
			((TextView)findViewById(R.id.cbISIQ2)).setText( R.string.s_ISIQ52 );
			((TextView)findViewById(R.id.cbISIQ3)).setText( R.string.s_ISIQ53 );
			((TextView)findViewById(R.id.cbISIQ4)).setText( R.string.s_ISIQ54 );
		}else if( cData31c.iQuestion == 4 ) { 
			((TextView)findViewById(R.id.tISIQ)).setText( R.string.s_ISIQ6 );
			((TextView)findViewById(R.id.cbISIQ0)).setText( R.string.s_ISIQ60 );
			((TextView)findViewById(R.id.cbISIQ1)).setText( R.string.s_ISIQ61 );
			((TextView)findViewById(R.id.cbISIQ2)).setText( R.string.s_ISIQ62 );
			((TextView)findViewById(R.id.cbISIQ3)).setText( R.string.s_ISIQ63 );
			((TextView)findViewById(R.id.cbISIQ4)).setText( R.string.s_ISIQ64 );
		}
		else if( cData31c.iQuestion == 5 ) { 
			((TextView)findViewById(R.id.tISIQ)).setText( R.string.s_ISIQ7 );
			((TextView)findViewById(R.id.cbISIQ0)).setText( R.string.s_ISIQ70 );
			((TextView)findViewById(R.id.cbISIQ1)).setText( R.string.s_ISIQ71 );
			((TextView)findViewById(R.id.cbISIQ2)).setText( R.string.s_ISIQ72 );
			((TextView)findViewById(R.id.cbISIQ3)).setText( R.string.s_ISIQ73 );
			((TextView)findViewById(R.id.cbISIQ4)).setText( R.string.s_ISIQ74 );
		}
		
		String sTitle = String.format(getResources().getString(R.string.s_ISITitle), cData31c.iQuestion+2);
		((TextView)findViewById(R.id.tvTopTitle)).setText( sTitle);
		((CheckBox)findViewById(R.id.cbISIQ0)).setChecked( cData31c.b0 );
		((CheckBox)findViewById(R.id.cbISIQ1)).setChecked( cData31c.b1 );
		((CheckBox)findViewById(R.id.cbISIQ2)).setChecked( cData31c.b2 );
		((CheckBox)findViewById(R.id.cbISIQ3)).setChecked( cData31c.b3 );
		((CheckBox)findViewById(R.id.cbISIQ4)).setChecked( cData31c.b4 );
		
		
	}
	
	@Override
	protected void onResume() {
		cData31c = new CBTi_Data31c(this);
		
		fetchScreen();
		if( anyChecked() ) {
			if( cData31c.iQuestion == 5 ) {
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
	
}