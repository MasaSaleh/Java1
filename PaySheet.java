public class PaySheet {
    private String weekEndingDate = "";
    private int[] week = new int[5];

    public PaySheet() {
        this.weekEndingDate = "";
        this.week = new int[]{0, 0, 0, 0, 0};
    }
    
    public PaySheet(String weekEndingDate, int[] week) {
        this.weekEndingDate = weekEndingDate;
        this.week = week;
    }

    public String getWeekEndingDate() {
        return weekEndingDate;
    }
    
    public void setWeekEndingDate(String weekEndingDate) {
        this.weekEndingDate = weekEndingDate;
    }

    public int[] getWeek() {
        return week;
    }
    
    public void setDays(int[] week) {
        this.week = week;
    }
    
    public int getWorkDays() {
    	int days = 0;
    	for (int i = 0; i < week.length; i++) {
    		if (week[i] > 0) {
    			days++;
    		}
    	}
    	return days;
    }
    
    public int getHours(int index) {
    	int days = 0;
    	for (int i = 0; i < week.length; i++) {
    		days += week[i];
    	}
    	return days;
    }

    public int getAbsences() {
    	int absences = 0;
    	for (int i = 0; i < week.length; i++) {
    		if (week[i] == 0) {
    			absences++;
    		}
    	}
    	
    	return absences;
    }
}