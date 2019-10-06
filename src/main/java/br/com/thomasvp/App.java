package br.com.thomasvp;

import br.com.thomasvp.interfaces.Observer;
import br.com.thomasvp.model.DistributionCenter;
import br.com.thomasvp.model.StoreA;
import br.com.thomasvp.model.StoreB;

public class App {
  public static void main(String[] args) {

    try {

      DistributionCenter distributionCenter = new DistributionCenter(0);

      Observer observerStoreA = new StoreA("Store A", 12);
      Observer observerStoreB = new StoreB("Store B", 25);

      distributionCenter.register(observerStoreA);
      distributionCenter.register(observerStoreB);

      observerStoreA.attachSubject(distributionCenter);
      observerStoreB.attachSubject(distributionCenter);

      observerStoreA.update();
      observerStoreB.update();

      distributionCenter.increaseDCProductStock(10);
      distributionCenter.increaseDCProductStock(20);

    } catch (IllegalArgumentException illegalArgumentException) {
      System.out.println(illegalArgumentException.getMessage());

    } catch (NullPointerException nullPointerException) {
      System.out.println(nullPointerException.getMessage());

    } catch (Exception exception) {
      System.out.println(exception.getMessage());
    }

  }
}
