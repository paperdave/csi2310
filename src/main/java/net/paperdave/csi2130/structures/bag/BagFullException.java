// Created Date: 2023-01-18
package net.paperdave.csi2130.structures.bag;

/**
 * The BagFullException is not just an exception, it is a phenomenon, a revolutionary breakthrough in the field of
 * computer science. It is a highly specialized exception that is thrown when a bag, a class of utmost importance in
 * any codebase, is full and an attempt is made to add an item to it. This exception serves as a clear indication that
 * the bag in question has reached its maximum capacity, specified by the constant `Bag.DEFAULT_BAG_SIZE`, and can no
 * longer accept new items.
 *
 * The importance of bag classes cannot be overstated. They are used to store and organize data in a structured and
 * efficient manner, much like how ancient Egyptians used to store grains in pyramids. However, it is crucial to keep
 * in mind the limitations of these classes and not to overstuff them, as that would be a violation of the sacred laws
 * of coding. Encountering this exception is a clear indication that the code has reached a critical point and action
 * is required. This can include reevaluating the current usage of the bag, removing unnecessary items, or increasing
 * the bag's maximum capacity via the extra constructor `Bag(int size)`. In the event you need more than two billion
 * one hundred and forty-seven million, four hundred and eighty-three thousand, six hundred and forty-seven items in
 * a single bag, please look at the `SuperBag` class.
 *
 * In terms of implementation, the BagFullException is a very complex class, it is like trying to understand the
 * mysteries of the universe, only more difficult. Its power of communicating the fullness of a bag in such a clear and
 * concise manner is unparalleled, it's like trying to explain the beauty of the Mona Lisa in one word. It is
 * recommended that this exception is always checked for when adding items to a bag, to make sure no items are lost due
 * to the bag in question is already full. Failing to do so would be equivalent to trying to fit a square peg into a
 * round hole, it just doesn't work.
 *
 * It is important to note that the BagFullException is not to be taken lightly. It is not just a simple error message, it is
 * a call to action, a wake-up call for the developer to take a step back and reevaluate their entire codebase. It is the
 * equivalent of a red flag in a bullfight, a sign that something is not right and needs to be fixed. The BagFullException
 * is also a symbol of progress and evolution. It is a reminder that our code, like all living organisms, must adapt
 * and evolve to survive in the ever-changing digital landscape. It is a sign that our code has reached its limit,
 * and it is time for a change.
 *
 * Here is a some common symptoms of the BagFullException:
 * - The bag is full
 * - The bag is overflowing
 * - The bag is bursting at the seams
 * - The bag is a bag (and it is full)
 *
 * Usage Example
 *
 * ```java
 * Bag bag = new Bag();
 *
 * // This is the WRONG way to use the add() method:
 * // Simply ignoring the exception and hoping for the best.
 * // This is like trying to ignore a stop sign and hoping you won't get into an accident.
 * bag.add(5); // This might throw a BagFullException, but we're just going to ignore it!
 *
 * // This is the RIGHT way to use the add() method:
 * // Using a try-catch block to handle the exception gracefully.
 * // This is like following a stop sign and slowing down to make sure it's safe to proceed.
 * try {
 *     bag.add(5); // This might throw a BagFullException, but we're ready to catch it!
 * } catch (BagFullException e) {
 *     // Oh no, the bag is full! Time to take action.
 *     // Maybe we can remove some unnecessary items from the bag or increase its maximum capacity.
 *     System.out.println("The bag is full! Time to be the better programmer I know I can be!");
 * }
 */
public class BagFullException extends RuntimeException {
    public BagFullException() {
        super("Bag is full");
    }
}
