package com.example.atestappforeverything.feature_wifi_provisioning.presentation.ui.provisioning

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.espressif.provisioning.ESPConstants
import com.espressif.provisioning.ESPProvisionManager
import com.espressif.provisioning.WiFiAccessPoint
import com.espressif.provisioning.listeners.WiFiScanListener
import com.example.atestappforeverything.databinding.WifiProvViewBinding
import com.google.android.material.snackbar.Snackbar
import java.lang.Exception
import java.util.ArrayList

class ProvisioningActivity : AppCompatActivity() {

    private lateinit var binding: WifiProvViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = WifiProvViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val device = ESPProvisionManager.getInstance(applicationContext).createESPDevice(
            ESPConstants.TransportType.TRANSPORT_SOFTAP,
            ESPConstants.SecurityType.SECURITY_0
        )

        device.scanNetworks(object : WiFiScanListener {
            override fun onWiFiScanFailed(e: Exception?) {
                Snackbar.make(binding.root, "${e?.message}", Snackbar.LENGTH_INDEFINITE).show()
            }

            override fun onWifiListReceived(wifiList: ArrayList<WiFiAccessPoint>?) {
                if (wifiList == null) {
                    Snackbar.make(binding.root, "Cannot receive any wifi :( ", Snackbar.LENGTH_LONG)
                        .show()
                } else {
                    wifiList.forEach {
                        Log.e("wifi list:", it.wifiName)
                    }
                }
            }
        })

    }
}