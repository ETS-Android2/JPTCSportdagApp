package p003nl.jpthijsse.sportdag;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentActivity;
import android.support.p000v4.app.FragmentManager;
import android.support.p000v4.app.FragmentPagerAdapter;
import android.support.p000v4.app.NavUtils;
import android.support.p000v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.Locale;

/* renamed from: nl.jpthijsse.sportdag.SportActivity */
public class SportActivity extends FragmentActivity {
    SectionsPagerAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        setContentView(C0054R.layout.activity_sport);
        this.mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        this.mViewPager = (ViewPager) findViewById(C0054R.C0055id.pager);
        this.mViewPager.setAdapter(this.mSectionsPagerAdapter);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0054R.menu.sport, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 16908332:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /* renamed from: nl.jpthijsse.sportdag.SportActivity$SectionsPagerAdapter */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public Fragment getItem(int position) {
            Fragment fragment = new SportSectionFragment();
            Bundle args = new Bundle();
            args.putInt("sport", getPageImg(position));
            fragment.setArguments(args);
            return fragment;
        }

        private int getPageImg(int pos) {
            switch (pos) {
                case 0:
                    return SportActivity.this.getResources().getIdentifier("nl.jpthijsse.sportdag:drawable/sprint", (String) null, (String) null);
                case 1:
                    return SportActivity.this.getResources().getIdentifier("nl.jpthijsse.sportdag:drawable/hardlopen", (String) null, (String) null);
                case 2:
                    return SportActivity.this.getResources().getIdentifier("nl.jpthijsse.sportdag:drawable/vortexwerpen", (String) null, (String) null);
                case 3:
                    return SportActivity.this.getResources().getIdentifier("nl.jpthijsse.sportdag:drawable/verspringen", (String) null, (String) null);
                case 4:
                    return SportActivity.this.getResources().getIdentifier("nl.jpthijsse.sportdag:drawable/hindernisbaan", (String) null, (String) null);
                case 5:
                    return SportActivity.this.getResources().getIdentifier("nl.jpthijsse.sportdag:drawable/kogelstoten", (String) null, (String) null);
                default:
                    return 0;
            }
        }

        public int getCount() {
            return 6;
        }

        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return SportActivity.this.getString(C0054R.string.sprint).toUpperCase(l);
                case 1:
                    return SportActivity.this.getString(C0054R.string.hardlopen).toUpperCase(l);
                case 2:
                    return SportActivity.this.getString(C0054R.string.vortex).toUpperCase(l);
                case 3:
                    return SportActivity.this.getString(C0054R.string.verspringen).toUpperCase(l);
                case 4:
                    return SportActivity.this.getString(C0054R.string.hindernisbaan).toUpperCase(l);
                case 5:
                    return SportActivity.this.getString(C0054R.string.kogel).toUpperCase(l);
                default:
                    return null;
            }
        }
    }

    /* renamed from: nl.jpthijsse.sportdag.SportActivity$DummySectionFragment */
    public static class DummySectionFragment extends Fragment {
        public static final String ARG_SECTION = "sport";

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(C0054R.layout.fragment_sport_dummy, container, false);
            ((ImageView) rootView.findViewById(2131230729)).setImageResource(getArguments().getInt("sport"));
            return rootView;
        }
    }

    /* renamed from: nl.jpthijsse.sportdag.SportActivity$SportSectionFragment */
    public static class SportSectionFragment extends Fragment implements AdapterView.OnItemSelectedListener {
        public static final String ARG_SECTION = "sport";
        public ArrayAdapter<CharSequence> klas1AAdapter;
        public ArrayAdapter<CharSequence> klas1BAdapter;
        public Spinner klasSpinner;
        public Spinner leerlingSpinner;

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(C0054R.layout.fragment_sport_dummy, container, false);
            ((ImageView) rootView.findViewById(C0054R.C0055id.sport_image)).setImageResource(getArguments().getInt("sport"));
            this.klasSpinner = (Spinner) rootView.findViewById(C0054R.C0055id.klas_spinner);
            ArrayAdapter<CharSequence> klasAdapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(), C0054R.array.klas, 17367048);
            klasAdapter.setDropDownViewResource(17367049);
            this.klasSpinner.setAdapter(klasAdapter);
            this.klasSpinner.setOnItemSelectedListener(this);
            this.leerlingSpinner = (Spinner) rootView.findViewById(C0054R.C0055id.leerling_spinner);
            this.leerlingSpinner.setOnItemSelectedListener(this);
            this.klas1AAdapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(), C0054R.array.leerlingen_1A, 17367048);
            this.klas1AAdapter.setDropDownViewResource(17367049);
            this.klas1BAdapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(), C0054R.array.leerlingen_1B, 17367048);
            this.klas1BAdapter.setDropDownViewResource(17367049);
            return rootView;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
            switch (pos) {
                case 0:
                    this.leerlingSpinner.setAdapter(this.klas1AAdapter);
                    return;
                case 1:
                    this.leerlingSpinner.setAdapter(this.klas1BAdapter);
                    return;
                default:
                    return;
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }
}
