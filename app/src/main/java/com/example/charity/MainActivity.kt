package com.example.charity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val homeFragment = HomeFragment()
        val searchFragment = SearchFragment()
        val donationFragment =DonationFragment()
        val profileFragment = ProfileFragment()
//        val searchFragment=fragment_search_2()

        val bottomNavigationView =findViewById<BottomNavigationView>(R.id.bottomNavigationView)

      replaceFragment(homeFragment)

        bottomNavigationView.setOnItemReselectedListener {
            when(it.itemId){
                R.id.miHome-> replaceFragment(homeFragment)
                R.id.miSearch-> replaceFragment(searchFragment)
                R.id.miDonation->replaceFragment(donationFragment)
                R.id.miProfile->replaceFragment(profileFragment)
            }
            true
        }

    }
    private fun replaceFragment(fragment: Fragment){
        if(fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, fragment)
            transaction.commit()
    }
}
}