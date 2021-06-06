package com.example.advertise

import android.Manifest
import android.os.Bundle
import android.os.Environment
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.advertise.databinding.ActivityPaintBinding
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.kyanogen.signatureview.SignatureView
import java.io.File


private lateinit var binding: ActivityPaintBinding

class PaintActivity : AppCompatActivity() {
    lateinit var signatureView: SignatureView
    lateinit var imgEraser: ImageButton
    lateinit var imgColor: ImageButton
    lateinit var imageSave: ImageButton
    lateinit var seekBar: SeekBar
    lateinit var txtPenSize: TextView

    private lateinit var fileName: String
    val root: String = Environment.getExternalStorageDirectory().toString()
    val path: File = File(root + "/MyPaintings")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_paint)
        askPermission()
    }

    private fun askPermission(){
        Dexter.withContext(this)
            .withPermissions(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
            ).withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport) { /* ... */
                    Toast.makeText(this@PaintActivity, "Permission allowed", Toast.LENGTH_SHORT).show()
                }

                override fun onPermissionRationaleShouldBeShown(
                    list: List<PermissionRequest?>?,
                    permissionToken: PermissionToken?
                ) {
                    // ask the permission until the user give the permission
                     permissionToken?.continuePermissionRequest()
                }
            }).check()
    }
}
