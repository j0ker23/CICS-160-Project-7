In total, I made 4 additional changes.

1. Added a new Knight class that has a boast ability and unique stats compared to the Wizard class. 
    Specifically, the boast ability allows the player to boost their damage for a limited number of rounds which should automatically expire. 
    The Knight can use these a limited amount of times per fight, encouraging strategy. This feature integrates cleanly with the existing system, 
    extending CombatEntity and PlayerControlled. The boast mechanic exists outside of the GameDrive loop, meaning it doesn't need to keep track of it. 
    In terms of SOLID principles, Knight extends CombatEntity so it should work for every instance of CombatEntity, satisfying Liskov's Substitution Principle

2. Added a Gambler class that has attacks and defence based on rng. 
    In term of damage, the Gambler rolls a d20 and based on what they roll, that's the damage they deal out. If the Gambler rolls a 1, they will slip
    and take 5 hits of damage instead. The Gambler also has built in defense, rolling a d5 and blocking that much damage. As seen with the Knight class,
    this follows Liskov's Substitution Principle due to how it extends CombatEntity. The randomness created using the Random class and is encapsulated within
    the Gambler class.

3. Added a Fireball Attack to Wizard.
    I added a new attack to the Wizard class and implemented a mana system. This mana system also allows this class to be open to additional spells.
    This new attack is a fireball attack that is stronger than the base attack, allowing for more strategy for when to use stronger attacks.
    This follows SOLID principles as it extends CombatEntity. It also, of course, follows Single Responsibility, as it only has one responsibility,
    that being a class for the Wizard class.

4. Added a Goblin Enemy.
    Finally, I added a Goblin enemy. Similar to the Gambler class, it relies on the Random class, to influence its attacks.
    It naturally has low attack power, however, it if hits the 50/50, it will deal a critical hit and do double damage. Goblin extends CombatEntity and 
    implements AIControlled, so it should be able to work in combat like Dragon. Therefore, this follows Liskov's Substitution Principle.