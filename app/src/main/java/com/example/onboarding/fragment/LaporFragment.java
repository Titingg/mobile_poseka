package com.example.onboarding.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.onboarding.MainActivity;
import com.example.onboarding.R;
import com.example.onboarding.SplashScreen;

import java.io.File;

public class LaporFragment extends Fragment {

private Button BTNsimpan;
private EditText ETnik;


//    ImageView IconBack, ImageLaporan;
//    EditText inputNama,inputTelepon, inputLokasidetail, inputTanggal, inputisiLaporan;
//    ImageButton btn_submit;
//    ProgressDialog progressDialog;
//    SessionManager sessionManager;
//    String pilihan, username, alamat, lokasi_detail, telepon, isi_laporan, tanggal;
//
//    //private static final int PHOTO_REQUEST_GALLERY = 1;//gallery
//    static final int REQUEST_TAKE_PHOTO = 1;
//    final int CODE_GALLERY_REQUEST = 999;
//    String rPilihan[]= {"Take a photo","From Album"};
//    public final String APP_TAG = "MyApp";
//    Bitmap bitMap = null;
//    public String photoFileName = "photo.jpg";
//    File photoFile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lapor, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button BTNsimpan = (Button) view.findViewById(R.id.simpan_button);
        EditText ETnik = (EditText) view.findViewById(R.id.input_nik);

        BTNsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Gagal Terkirim"+ETnik.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

//
//
//            @Override
//            protected void onCreate(Bundle savedInstanceState) {
//                super.onCreate(savedInstanceState);
//                setContentView(R.layout.activity_laporan);
//
//                inputNama = findViewById(R.id.inputNama);
//                inputTanggal = findViewById(R.id.inputTanggal);
//                btn_submit = findViewById(R.id.btn_submit);
//                inputTelepon = findViewById(R.id.inputTelepon);
//                inputLokasidetail = findViewById(R.id.inputLokasi);
//                inputisiLaporan = findViewById(R.id.inputLaporan);
//
//                sessionManager = new SessionManager(getApplicationContext());
//                HashMap<String, String> user = sessionManager.getUserDetails();
//                username = user.get(SessionManager.KEY_USERNAME);
//
//                inputNama.setText(username);
//
//                IconBack.setOnClickListener(new View.OnClickListener() {
//                    public void onClick(View v) {
//
//                        onBackPressed();
//
//                    }
//                });
//
//                Date currentTime = Calendar.getInstance().getTime();
//                String formattedData = DateFormat.getDateInstance(DateFormat.FULL).format(currentTime);
//                inputTanggal.setText(formattedData);
//
//
//                ImageLaporan.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//
//                        if (bitMap != null) {
//
//                            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(LaporanActivity.this);
//                            alertDialogBuilder.setMessage("Do yo want to take photo again?");
//
//                            alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface arg0, int arg1) {
//                                    //Toast.makeText(context,"You clicked yes button",Toast.LENGTH_LONG).show();
//                                    //call fuction of TakePhoto
//                                    TakePhoto();
//                                }
//                            });
//
//                            alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog, int which) {
//
//                                }
//                            });
//
//                            AlertDialog alertDialog = alertDialogBuilder.create();
//                            alertDialog.show();
//
//
//                        } else {
//
//                            TakePhoto();
//                        }
//                    }
//                });
//
//                btn_submit.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        //progressDialog.setMessage("Menambahkan Data...");
//                        //progressDialog.setCancelable(false);
//                        //progressDialog.show();
//
//                        username        = inputNama.getText().toString();
//                        telepon         = inputTelepon.getText().toString();
//                        tanggal         = inputTanggal.getText().toString();
//                        lokasi_detail   = inputLokasidetail.getText().toString();
//                        isi_laporan     = inputisiLaporan.getText().toString();
//
//                        if (bitMap == null){
//
//                            AlertDialog.Builder builder = new AlertDialog.Builder(LaporanActivity.this);
//                            builder.setMessage("Please take a photo ");
//                            AlertDialog alert1 = builder.create();
//                            alert1.show();
//                            progressDialog.dismiss();
//
//
//                        }
//                        else {
//
//                            validasiData();
//
//                        }
//                    }
//                });
//
//
//
//            }
//
//            void validasiData(){
//                if(username.equals("") || telepon.equals("") || lokasi_detail.equals("") || tanggal.equals("") || isi_laporan.equals("") ){
//                    //progressDialog.dismiss();
//                    Toast.makeText(LaporanActivity.this, "Periksa kembali data yang anda masukkan !", Toast.LENGTH_SHORT).show();
//                }else {
//                    kirimData();
//                }
//            }
//
//
//            // taking image
//            public  void TakePhoto(){
//                // Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(LaporanActivity.this);
//                builder.setTitle("Select");
//                builder.setItems(rPilihan, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//
//                        pilihan = String.valueOf(rPilihan[which]);
//
//                        if (pilihan.equals("Take a photo"))
//                        {
//                            // create Intent to take a picture and return control to the calling application
//                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                            // Create a File reference to access to future access
//                            photoFile = getPhotoFileUri(photoFileName);
//
//                            // wrap File object into a content provider
//                            // required for API >= 24
//                            // See https://guides.codepath.com/android/Sharing-Content-with-Intents#sharing-files-with-api-24-or-higher
//                            String authorities = getPackageName() + ".fileprovider";
//                            Uri fileProvider = FileProvider.getUriForFile(LaporanActivity.this, authorities, photoFile);
//                            intent.putExtra(MediaStore.EXTRA_OUTPUT, fileProvider);
//
//                            // If you call startActivityForResult() using an intent that no app can handle, your app will crash.
//                            // So as long as the result is not null, it's safe to use the intent.
//                            if (intent.resolveActivity(getPackageManager()) != null) {
//                                // Start the image capture intent to take photo
//                                startActivityForResult(intent, REQUEST_TAKE_PHOTO);
//
//                            }
//                        }
//                        else
//                        {
//
//                            ActivityCompat.requestPermissions(LaporanActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, CODE_GALLERY_REQUEST);
//
//                        }
//
//
//
//                    }
//                });
//                builder.show();
//
//
//            }
//            //permission
//            public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//
//                if (requestCode == CODE_GALLERY_REQUEST){
//                    if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
//                        Intent intent = new Intent(Intent.ACTION_PICK);
//                        intent.setType("image/*");
//                        startActivityForResult(Intent.createChooser(intent, "Select Image"), CODE_GALLERY_REQUEST);
//                    }else{
//                        Toast.makeText(getApplicationContext(), "You don't have permission to access gallery!", Toast.LENGTH_LONG).show();
//                    }
//                    return;
//                }
//                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//            }
//
//            @Override
//            public void onActivityResult(int requestCode, int resultCode, Intent intent) {
//
//                //set photo size
//                super.onActivityResult(requestCode, resultCode, intent);
//                if (requestCode == REQUEST_TAKE_PHOTO) {
//                    if (resultCode == Activity.RESULT_OK) {
//                        // by this point we have the camera photo on disk
//                        //Bitmap takenImage = BitmapFactory.decodeFile(String.valueOf(photoFile));
//                        // RESIZE BITMAP, see section below
//                        // Load the taken image into a preview
//                        bitMap = decodeSampledBitmapFromFile(String.valueOf(photoFile), 1000, 700);
//                        ImageLaporan.setImageBitmap(bitMap);
//                    } else { // Result was a failure
//                        Toast.makeText(LaporanActivity.this, "Picture wasn't taken!", Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    if (intent != null) {
//                        Uri photoUri = intent.getData();
//                        // Do something with the photo based on Uri
//                        bitMap = null;
//                        try {
//                            //InputStream inputStream = getContentResolver().openInputStream(photoUri);
//                            //bitMap = BitmapFactory.decodeStream(inputStream);
//
//                            //btnImage.setVisibility(View.VISIBLE);
//                            bitMap = MediaStore.Images.Media.getBitmap(getContentResolver(), photoUri);
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                        // Load the selected image into a preview
//                        ImageLaporan.setImageBitmap(bitMap);
//                    }
//                }
//            }
//            //get data photo
//            public File getPhotoFileUri(String fileName)  {
//                // Only continue if the SD Card is mounted
//                if (isExternalStorageAvailable()) {
//                    // Get safe storage directory for photos
//                    // Use getExternalFilesDir on Context to access package-specific directories.
//                    // This way, we don't need to request external read/write runtime permissions.
//                    File mediaStorageDir = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), APP_TAG);
//
//                    // Create the storage directory if it does not exist
//                    if (!mediaStorageDir.exists() && !mediaStorageDir.mkdirs()){
//                        Log.d(APP_TAG, "failed to create directory");
//                    }
//                    File file = new File(mediaStorageDir.getPath() + File.separator + fileName);
//
//                    return file;
//
//                }
//                return null;
//            }
//
//            //set photo
//            public static Bitmap decodeSampledBitmapFromFile(String path, int reqWidth, int reqHeight) { // BEST QUALITY MATCH
//
//                //First decode with inJustDecodeBounds=true to check dimensions
//                final BitmapFactory.Options options = new BitmapFactory.Options();
//                options.inJustDecodeBounds = true;
//                BitmapFactory.decodeFile(path, options);
//
//                // Calculate inSampleSize, Raw height and width of image
//                final int height = options.outHeight;
//                final int width = options.outWidth;
//                options.inPreferredConfig = Bitmap.Config.RGB_565;
//                int inSampleSize = 1;
//
//                if (height > reqHeight) {
//                    inSampleSize = Math.round((float) height / (float) reqHeight);
//                }
//                int expectedWidth = width / inSampleSize;
//
//                if (expectedWidth > reqWidth) {
//                    //if(Math.round((float)width / (float)reqWidth) > inSampleSize) // If bigger SampSize..
//                    inSampleSize = Math.round((float) width / (float) reqWidth);
//                }
//
//                options.inSampleSize = inSampleSize;
//
//                // Decode bitmap with inSampleSize set
//                options.inJustDecodeBounds = false;
//
//                return BitmapFactory.decodeFile(path, options);
//            }
//
//            // Returns true if external storage for photos is available
//            private boolean isExternalStorageAvailable() {
//                String state = Environment.getExternalStorageState();
//                return state.equals(Environment.MEDIA_MOUNTED);
//            }
//
//
//            // get encode image to minimize image
//            public String getStringImage(Bitmap bmp){
//
//                ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                bmp.compress(Bitmap.CompressFormat.JPEG, 50, baos);
//                byte[] imageBytes = baos.toByteArray();
//                String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
//                return encodedImage;
//            }
//
//            void kirimData(){
//                String foto = getStringImage(bitMap);
//                AndroidNetworking.post("https://tkjbpnup.com/kelompok_2/addLaporan.php")
//                        .addBodyParameter("tanggal",""+tanggal)
//                        .addBodyParameter("nama",""+username)
//                        .addBodyParameter("lokasidetail",""+lokasi_detail)
//                        .addBodyParameter("isilaporan",""+isi_laporan)
//                        .addBodyParameter("nohp",""+telepon)
//                        .addBodyParameter("foto",""+foto)
//                        .setPriority(Priority.MEDIUM)
//                        .setTag("Tambah Data")
//                        .build()
//                        .getAsJSONObject(new JSONObjectRequestListener() {
//                            @Override
//                            public void onResponse(JSONObject response) {
//                                //progressDialog.dismiss();
//                                Log.d("cekTambah",""+response);
//                                try {
//                                    Boolean status = response.getBoolean("status");
//                                    String pesan   = response.getString("result");
//                                    Toast.makeText(LaporanActivity.this, ""+pesan, Toast.LENGTH_SHORT).show();
//                                    Log.d("status",""+status);
//                                    if(status){
//                                        new AlertDialog.Builder(LaporanActivity.this)
//                                                .setMessage("Berhasil Menambahkan Data !")
//                                                .setCancelable(false)
//                                                .setPositiveButton("Kembali", new DialogInterface.OnClickListener() {
//                                                    @Override
//                                                    public void onClick(DialogInterface dialog, int which) {
//                                                        Intent i = new Intent(LaporanActivity.this, HomeFragment.class);
//                                                        startActivity(i);
//                                                    }
//                                                })
//                                                .show();
//                                    }
//                                    else{
//                                        new AlertDialog.Builder(LaporanActivity.this)
//                                                .setMessage("Gagal Menambahkan Data !")
//                                                .setPositiveButton("Kembali", new DialogInterface.OnClickListener() {
//                                                    @Override
//                                                    public void onClick(DialogInterface dialog, int which) {
//                                                        Intent i = new Intent(LaporanActivity.this, HomeFragment.class);
//                                                        startActivity(i);
//                                                    }
//                                                })
//                                                .setCancelable(false)
//                                                .show();
//                                    }
//                                }catch (Exception e){
//                                    e.printStackTrace();
//                                }
//
//
//                            }
//
//                            @Override
//                            public void onError(ANError anError) {
//                                Log.d("ErrorTambahData",""+anError.getErrorBody());
//                            }
//                        });
//            }








    }
}