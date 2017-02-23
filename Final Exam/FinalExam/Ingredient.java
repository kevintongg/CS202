package FinalExam;

/**
 * Created by kcr12 on 17/3/2016.
 */
public class Ingredient {

  private String ingredientName;

  public Ingredient(String ingredientName) {

    this.ingredientName = ingredientName;
  }

  @Override
  public String toString() {
    return "Name of ingredient: " + ingredientName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Ingredient that = (Ingredient) o;

    return ingredientName != null ? ingredientName.equals(that.ingredientName) : that.ingredientName == null;

  }

  @Override
  public int hashCode() {
    return ingredientName != null ? ingredientName.hashCode() : 0;
  }

  public String getIngredientName() {

    return ingredientName;
  }

  public void setIngredientName(String ingredientName) {
    this.ingredientName = ingredientName;
  }
}
