package ua.edu.ucu.apps.task1;

public class Section {
    private int denomination;
    private Section next;

    public Section(int denomination) {
        this.denomination = denomination;
    }

    public void setNext(Section next) {
        this.next = next;
    }

    private boolean hasNext() {
        return next != null;
    }

    public void process(int amount) {
        if (amount >= denomination) {
            int count = amount / denomination;
            int left = amount % denomination;
            System.out.println("Dispensing " + count + " coin(s) of denomination " + denomination);
            if (left != 0 && hasNext()) {
                next.process(left);
            } else if (left != 0) {
                System.out.println("Cannot dispense remaining amount: " + left);
            }
        } else if (next != null) {
            next.process(amount);
        } else {
            System.out.println("Cannot dispense amount: " + amount);
        }
    }
}
