package cput.ac.za.Domain.Builder;

public interface AbstractBuilder<T> {
    //for creating a meal entity
    public void buildMeal();
    public void buildDrink();
    public T getProduct(); // we can choose this when we begin the implementations of classes
}
