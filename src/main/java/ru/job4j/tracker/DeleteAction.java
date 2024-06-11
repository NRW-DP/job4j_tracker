package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Delete item ===");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            tracker.delete(id);
            out.println("Order deleted successfully");
            return true;
        } else{
            out.println("Errors of deleting an order: order with id " + id + " not found.");
            return false;
        }
    }
}
