package Dto;

public class Task {
	
	private int taskId;
	private String taskDescription;
	private String taskPriority;
	private String taskDueDate;
	private int userId;
	private String taskTitle;
	
//	public Task(int taskId,String taskTitle, String taskDescription, String taskPriority, String taskDueDate, int userId) {
//	
//		this.taskId = taskId;
//		this.taskDescription = taskDescription;
//		this.taskPriority = taskPriority;
//		this.taskDueDate = taskDueDate;
//		this.userId = userId;
//		this.taskTitle=taskTitle;
//	}


	public Task() {
		// TODO Auto-generated constructor stub
	}


	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public String getTaskPriority() {
		return taskPriority;
	}

	public void setTaskPriority(String taskPriority ) {
		this.taskPriority = taskPriority;
	}

	public String getTaskDueDate() {
		return taskDueDate;
	}

	public void setTaskDueDate(String taskDueDate) {
		this.taskDueDate = taskDueDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	
	
	
	
	
}
