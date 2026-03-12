package org;

import org.producerconsumer.ProducerConsumer;
import org.producerconsumer.VersionSelection;

public class PandCMain {
    static void main() {
        //ProducerConsumer pc = new ProducerConsumer(5, VersionSelection.V1);
        ProducerConsumer pc = new ProducerConsumer(5, VersionSelection.V2);
        new Thread(pc::consumer).start();
        new Thread(pc::consumer).start();
        new Thread(pc::consumer).start();
        new Thread(pc::consumer).start();
        new Thread(pc::consumer).start();
        new Thread(pc::consumer).start();
        new Thread(pc::consumer).start();
        new Thread(pc::consumer).start();
        new Thread(pc::consumer).start();
        new Thread(pc::consumer).start();
        new Thread(pc::consumer).start();
        new Thread(pc::consumer).start();
        new Thread(pc::consumer).start();
        new Thread(pc::consumer).start();
        new Thread(pc::producer).start();
        new Thread(pc::producer).start();
    }
}
