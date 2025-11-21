public interface Healer {
    public void heal(Character character) throws DeadCharacterException;
    int getHealCapacity();
}
