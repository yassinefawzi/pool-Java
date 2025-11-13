public class Sorcerer extends Character implements Healer {
    private final int healCapacity;

    public Sorcerer(String name, int maxHealth, int healCapacity, Weapon weapon) {
        super(name, maxHealth, weapon);
        this.healCapacity = healCapacity;
    }

    public int getHealCapacity() {
        return healCapacity;
    }

    public void heal(Character character) throws DeadCharacterException {
        if (getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        if (character.getCurrentHealth() == 0) {
            throw new DeadCharacterException(character);
        }
        character.receiveHeals(healCapacity);
    }

    @Override
    public void attack(Character character) throws DeadCharacterException {
        if (getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        int damage = getWeapon() != null ? getWeapon().getDamage() : 10;
        character.takeDamage(damage);
    }

    @Override
    public void takeDamage(int damage) throws DeadCharacterException {
        if (getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        setCurrentHealth(getCurrentHealth() - damage);
    }

    @Override
    public String toString() {
        String str;
        if (getCurrentHealth() == 0) {
            str = getName() + " is a dead sorcerer. So bad, it could heal " + healCapacity + " HP.";
        } else {
            str = getName() + " is a sorcerer with " + getCurrentHealth() + " HP. It can heal " + healCapacity + " HP.";
        }
        if (getWeapon() != null)
            str += " He has the weapon " + getWeapon().toString() + ".";
        return str;
    }
}