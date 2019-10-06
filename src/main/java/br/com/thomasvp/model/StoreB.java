package br.com.thomasvp.model;

import br.com.thomasvp.interfaces.Observer;
import br.com.thomasvp.interfaces.Subject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class StoreB implements Observer {

  @NonNull
  private String observerName;

  @NonNull
  private Integer localProductStock;

  private Subject subjectToDistCenter;

  @Override
  public void update() {
    Integer productStockFromDistCenter = (Integer) this.subjectToDistCenter.getUpdate(this);

    if (productStockFromDistCenter.intValue() <= 0)
      System.out.println("Observer: " + this.observerName + "\nProduct stock in DC was not increased\n");
    else {
      System.out.println("Product stock in DC was increased!");

      this.localProductStock += productStockFromDistCenter;

      System.out.println(">> Observer: " + this.observerName +
        "\t STOCK NOW = " + String.valueOf(this.localProductStock) + "\n");
    }
  }

  @Override
  public void attachSubject(Subject subject) {
    this.subjectToDistCenter = subject;
  }

}
