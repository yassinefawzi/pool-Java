public class DeadCharacterException extends Exception {
    private final Character character;
    public DeadCharacterException(Character character) {
        this.character = character;
    }

   @Override
    public String getMessage() {
        String type = switch (character.getClass().getSimpleName()) {
            case "Sorcerer"	-> "sorcerer";
            case "Templar"	-> "templar";
            case "Monster"	-> "monster";
            default	-> "character";
        };
        return "The " + type + " " + character.getName() + " is dead.";
    }
}