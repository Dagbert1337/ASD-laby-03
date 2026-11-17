import java.io.File;
import java.io.IOException;
import java.util.Random;

void main() throws IOException {

    //------------------------------------------------
    // Zad 1.
    // Budowanie kopców dla danych malejących
    //------------------------------------------------
    Node leftistHeap = null;
    Node skewHeap = null;
    Node nnHeap = null;

    for (int value = 40; value >= 1; value--)
    {
        //Dodaj do każdego z kopców nowy węzeł z wartością value:
        //  leftistHeap = leftistHeap + value
        //  skewHeap = skewHeap + value
        //  nnHeap = nnHeap + value

        //Po każdej wstawianej 10-ce generuj rysunki:
        int count = 41 - value;
        if (count % 10 == 0) {
            TreeDrawer.drawTree(leftistHeap, count, new File("leftistHeap_" + count + ".png"));
            TreeDrawer.drawTree(skewHeap, count, new File("skrewHeap_" + count + ".png"));
            TreeDrawer.drawTree(nnHeap, count, new File("nnHeap_" + count + ".png"));
        }
    }

    //------------------------------------------------
    // Zad 2.
    // Wyznaczanie wysokości i najgłębszych węzłów kopców
    //------------------------------------------------
    System.out.println("Wysokość kopca lewostronnego : ???");
    System.out.println("Najgłębsze węzły kopca lewostronnego: ");

    System.out.println("Wysokość kopca skośnego : ???");
    System.out.println("Najgłębsze węzły kopca skośnego: ");

    System.out.println("Wysokość kopca NN : ???");
    System.out.println("Najgłębsze węzły NN: ");


    //------------------------------------------------
    // Zad 3.
    // Konwersja kopca skośnego MAX do MIN
    //------------------------------------------------
    Node minSkewHeap = null;  //ConvertToMIN(skewHeap)
    TreeDrawer.drawTree(minSkewHeap, 40, new File("skewHeap_min_40.png"));
}
