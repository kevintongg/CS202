package FinalExam;

/**
 * Created by kcr12 on 17/3/2016.
 */
public class Recipe {

    private String recipeName;

    public Recipe(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recipe recipe = (Recipe) o;

        return recipeName != null ? recipeName.equals(recipe.recipeName) : recipe.recipeName == null;

    }

    @Override
    public int hashCode() {
        return recipeName != null ? recipeName.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Name of recipe: " + recipeName;
    }
}
