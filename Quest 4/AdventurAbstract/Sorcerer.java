public class Sorcerer extends Character implements Healer {
	private final int healCapacity;

	public Sorcerer(String name, int maxHealth, int healCapacity) {
		super(name, maxHealth);
		this.healCapacity = healCapacity;
	}

	public int getHealCapacity() {
		return healCapacity;
	}

	public void heal(Character character) {
		receiveHeals(healCapacity);
	}

	@Override
	public void attack(Character character) {
		heal(character);
		character.takeDamage(10);
	}

	@Override
	public void takeDamage(int damage) {
		this.receiveHeals(-damage);
	}

	@Override
	public String toString() {
		if (getCurrentHealth() == 0) {
			return getName() + " is a dead sorcerer. So bad, it could heal " + healCapacity + " HP.";
		}
		return getName() + " is a sorcerer with " + getCurrentHealth() + " HP. It can heal " + healCapacity + " HP.";
	}
}
