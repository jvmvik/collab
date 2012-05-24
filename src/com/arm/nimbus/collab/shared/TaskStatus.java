package com.arm.nimbus.collab.shared;

/***
 * Task Status available.
 * 
 * This class is shared by the client and the server.
 * 
 * @author victor
 *
 */
public enum TaskStatus {
	
	InProgress("inProgress"), Planned("Planned"), Completed("Completed");
	
	/**
     * @param text
     */
    private TaskStatus(final String text) {
        this.text = text;
    }

    private final String text;

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return text;
    }

	
}
