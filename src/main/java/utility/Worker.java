package utility;

import coreFurniture.FurnitureJournal;

public interface Worker {
    public void saw(FurnitureJournal furnitureJournal, Firewood firewood);
    public void plane(FurnitureJournal furnitureJournal, Firewood firewood);
    public void knockTogether(FurnitureJournal furnitureJournal, Firewood firewood);
}
