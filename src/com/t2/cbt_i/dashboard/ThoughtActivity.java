package com.t2.cbt_i.dashboard;

import java.util.Random;
import java.util.Stack;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseActivity;

public class ThoughtActivity extends CBTi_BaseActivity
{
	Boolean bIsSleep = true;
	private Stack<Integer> previousThoughts = new Stack<Integer>();
	int iRidSleep[] = { R.string.s_Thought_Sleep01, R.string.s_Thought_Sleep02, R.string.s_Thought_Sleep03, R.string.s_Thought_Sleep04,
			R.string.s_Thought_Sleep05, R.string.s_Thought_Sleep06, R.string.s_Thought_Sleep07, R.string.s_Thought_Sleep08, R.string.s_Thought_Sleep09,
			R.string.s_Thought_Sleep10, R.string.s_Thought_Sleep11, R.string.s_Thought_Sleep12, R.string.s_Thought_Sleep13 };
	int iRidTrauma[] = { R.string.s_Thought_Trauma01, R.string.s_Thought_Trauma02, R.string.s_Thought_Trauma03, R.string.s_Thought_Trauma04,
			R.string.s_Thought_Trauma05, R.string.s_Thought_Trauma06, R.string.s_Thought_Trauma07, R.string.s_Thought_Trauma08, R.string.s_Thought_Trauma09,
			R.string.s_Thought_Trauma10, R.string.s_Thought_Trauma11, R.string.s_Thought_Trauma12, R.string.s_Thought_Trauma13 };

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_thought);

		Bundle b = getIntent().getExtras();
		bIsSleep = b.getBoolean("THINKABOUT");
		
		if(bIsSleep)
		{
			this.setTitle(R.string.s_WorriedAboutSleep);
		}
		else
		{
			this.setTitle(R.string.s_WorriedAboutTrauma);			
		}

		View v = findViewById(R.id.lBamboo);
		v.getBackground().setAlpha(45);

		getThought();

		// Try Another
		((Button) findViewById(R.id.bTryAnother)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				getThought();
			}
		});

		// Previous
		((Button) findViewById(R.id.bPrevious)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if(!previousThoughts.isEmpty())
				{
					if (bIsSleep)
						((TextView) findViewById(R.id.tThought)).setText(iRidSleep[previousThoughts.pop()]);
					else
						((TextView) findViewById(R.id.tThought)).setText(iRidTrauma[previousThoughts.pop()]);
				}
				else
				{
					getThought();
				}
			}
		});
	}

	private void getThought()
	{
		Random r = new Random();
		int i = r.nextInt(12);
		previousThoughts.add(i);
		if (bIsSleep)
			((TextView) findViewById(R.id.tThought)).setText(iRidSleep[i]);
		else
			((TextView) findViewById(R.id.tThought)).setText(iRidTrauma[i]);
	}

	@Override
	public void onBackPressed()
	{
		super.onBackPressed();
		ThoughtActivity.this.overridePendingTransition(R.anim.slide_right, R.anim.slide_right2);
	}
}
