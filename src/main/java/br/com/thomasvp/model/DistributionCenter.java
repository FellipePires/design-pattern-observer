package br.com.thomasvp.model;

import java.util.ArrayList;
import java.util.List;

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
public class DistributionCenter implements Subject {

  private List<Observer> observers = new ArrayList<Observer>();

  @NonNull
  private Integer productStock;

  @Override
  public void register(Observer observer) {
    if (observer == null)
      throw new NullPointerException("Observer passed in is null");

    if (this.observers.contains(observer))
      throw new IllegalArgumentException("Observer already exists");

    this.observers.add(observer);
  }

  @Override
  public void unregister(Observer observer) {
    if (observer == null)
      throw new NullPointerException("Observer passed in is null");

    if (this.observers.contains(observer))
      throw new IllegalArgumentException("Observer already exists");

    this.observers.remove(observer);
  }

  @Override
  public void notifyObservers() {
    for (Observer observer: this.observers) {
      observer.update();
    }
  }

  @Override
  public Integer getUpdate(Observer observer) {
    return this.productStock;
  }

  public void increaseDCProductStock(Integer amount) {
    System.out.println("!!! Actual Distribution Center's stock = " + this.productStock + "\n");

    System.out.println("++ Increase products in Distribution Center stock (qty): +" + amount + "\n");
    this.productStock += amount;

    notifyObservers();
  }

}
