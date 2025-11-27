
import java.util.ArrayList;
import java.util.List;

public class Mochila {
    private List<Item> mochila;

    public Mochila() {
        mochila = new ArrayList<>();
    }

    public void adicionarItem(Item e) {
        this.mochila.add(e);
    }

}
