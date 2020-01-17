package com.example.musicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.media.AudioManager;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import java.io.IOException;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    TextView drake;
    TextView sia;
    TextView tovelo;
    TextView irina;
    TextView queen;
    TextView motans;
    ImageView pause;
    ImageView next;
    ImageView prev;
    ImageView play;
    TextView nowPlaying;
    TextView queue;

    int sindex;

    String AudioURL1 = "https://ia803103.us.archive.org/32/items/asd64/Drake%20-%20God%27s%20Plan%20%28Lyrics%29.mp3";
    String AudioURL2 = "https://ia800200.us.archive.org/10/items/Sia2014-12-12.alive/Sia-ChandelierlyricsVideohd.mp3";
    String AudioURL3 = "https://ia800705.us.archive.org/20/items/tove-lo-habits-hippie-sabotage-remix-8d-audio/tove-lo-habits-hippie-sabotage-remix-8d-audio.mp3";
    String AudioURL4 = "https://ia803001.us.archive.org/6/items/yuria-music_20190405/IrinaRimes-InLoculMeu.mp3";
    String AudioURL5 = "https://ia800709.us.archive.org/16/items/MP3FY.COMHalseyWithoutMeAudio_201812/%5BMP3FY.COM%5D%20Halsey%20-%20Without%20Me%20%28Audio%29.mp3";
    String AudioURL6 = "https://ia800802.us.archive.org/11/items/QueenBohemianRhapsodyOfficialVideo_201710/Queen%20-%20Bohemian%20Rhapsody%20%28Official%20Video%29.mp3";

    MediaPlayer mediaplayer;

    ArrayList songs = new ArrayList<String>();
    ArrayList songText = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sindex = -1;
        boolean paused = true;

        pause = (ImageView)findViewById(R.id.pause);
        next = (ImageView)findViewById(R.id.next);
        prev = (ImageView)findViewById(R.id.prev);
        play = (ImageView)findViewById(R.id.play);

        drake = (TextView)findViewById(R.id.song1);
        sia = (TextView)findViewById(R.id.song2);
        tovelo = (TextView)findViewById(R.id.song3);
        irina = (TextView)findViewById(R.id.song4);
        queen = (TextView)findViewById(R.id.song5);
        motans = (TextView)findViewById(R.id.song6);
        nowPlaying = (TextView)findViewById(R.id.nowPlaying);
        queue = (TextView) findViewById(R.id.queue);

        mediaplayer = new MediaPlayer();
        mediaplayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        mediaplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaplayer) {
                try {
                    mediaplayer.stop();
                    mediaplayer.reset();
                    mediaplayer.setDataSource((String)songs.get(++sindex));
                    mediaplayer.prepare();
                    mediaplayer.start();

                }catch(Exception e)
                {}

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    if(songs.size() > sindex) {
                        mediaplayer.stop();
                        mediaplayer.reset();
                        mediaplayer.setDataSource((String)songs.get(++sindex));
                        mediaplayer.prepare();
                        mediaplayer.start();

                    }

                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }



            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    if(sindex > 0) {
                        mediaplayer.stop();
                        mediaplayer.reset();
                        mediaplayer.setDataSource((String)songs.get(--sindex));
                        mediaplayer.prepare();
                        mediaplayer.start();


                    }
                    if(sindex == 0)sindex = -1;

                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }



            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(mediaplayer.isPlaying()) {
                        mediaplayer.pause();
                        play.setVisibility(View.VISIBLE);
                        pause.setVisibility(View.GONE);

                    }

                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (SecurityException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalStateException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }



            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(!mediaplayer.isPlaying()) {
                        mediaplayer.start();
                        pause.setVisibility(View.VISIBLE);
                        play.setVisibility(View.GONE);
                    }

                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (SecurityException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalStateException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }



            }
        });

        drake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    nowPlaying.setText("");
                    nowPlaying.append("Next: " + getString(R.string.song1));
                    songs.add(AudioURL1);
                    songText.add(R.string.song1);
                    if(sindex == -1){
                        mediaplayer.setDataSource(AudioURL1);
                        mediaplayer.prepare();
                        mediaplayer.start();

                        sindex++;
                    }


                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();

                } catch (SecurityException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalStateException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }



            }
        });

        sia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    nowPlaying.setText("");
                    nowPlaying.append("Next: " + getString(R.string.sia_helium));
                    songs.add(AudioURL2);
                    songText.add(R.string.sia_helium);
                    if(sindex == -1){
                        mediaplayer.setDataSource(AudioURL2);
                        mediaplayer.prepare();
                        nowPlaying.setText("");
                        mediaplayer.start();

                        sindex++;

                    }


                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (SecurityException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalStateException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }


            }
        });

        tovelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    nowPlaying.setText("");
                    nowPlaying.append("Next: " + getString(R.string.tovelo_habits));
                    songs.add(AudioURL3);
                    songText.add(R.string.tovelo_habits);
                    if(sindex == -1){
                        mediaplayer.setDataSource(AudioURL3);
                        mediaplayer.prepare();
                        nowPlaying.setText("");
                        mediaplayer.start();

                        sindex++;

                    }


                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (SecurityException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalStateException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }


            }
        });

        irina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    nowPlaying.setText("");
                    nowPlaying.append("Next: " + getString(R.string.irina_barbat));

                    songs.add(AudioURL4);
                    songText.add(R.string.irina_barbat);
                    if(sindex == -1){
                        mediaplayer.setDataSource(AudioURL4);
                        mediaplayer.prepare();

                        mediaplayer.start();


                        sindex++;



                    }


                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (SecurityException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalStateException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }



            }
        });

        queen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    nowPlaying.setText("");
                    nowPlaying.append("Next " + getString(R.string.halsey_without));

                    songs.add(AudioURL5);

                    songText.add(R.string.halsey_without);
                    if(sindex == -1){
                        mediaplayer.setDataSource(AudioURL5);
                        mediaplayer.prepare();
                        nowPlaying.setText("");
                        mediaplayer.start();


                        sindex++;
                    }



                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (SecurityException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalStateException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });

        motans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    nowPlaying.setText("");
                    nowPlaying.append("Next: " + getString(R.string.motans_nascut));

                    songs.add(AudioURL6);
                    songText.add(R.string.motans_nascut);
                    if(sindex == -1){
                        mediaplayer.setDataSource(AudioURL6);
                        mediaplayer.prepare();
                        mediaplayer.start();


                        sindex++;

                    }


                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (SecurityException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalStateException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });

        queue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent queue = new Intent(HomeActivity.this, QueueActivity.class);
                startActivity(queue);
            }
        });



    }




}
