package br.com.thomasvp.interfaces;

public interface Observer {
  public void update();

  public void attachSubject(Subject subject);
}
