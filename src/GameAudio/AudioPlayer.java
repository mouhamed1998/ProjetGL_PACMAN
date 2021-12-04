package GameAudio;

/**
 * AudioPlayer est une interface avec deux méthodes
 * start() qui permet de déclencher un son
 * stop() qui permet d'arreter le son
 */
public interface AudioPlayer {
    void start();
    void pause();
    void stop();
    void loop();
}
