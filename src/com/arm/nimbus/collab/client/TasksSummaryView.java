package com.arm.nimbus.collab.client;

import java.util.List;
import java.util.logging.Logger;

import com.arm.nimbus.collab.server.model.Task;
import com.arm.nimbus.collab.server.model.User;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;

public class TasksSummaryView extends Composite implements HasText {

	Logger log = Logger.getLogger("taskSummaryView");
	
	private static TasksSummaryViewUiBinder uiBinder = GWT
			.create(TasksSummaryViewUiBinder.class);

	interface TasksSummaryViewUiBinder extends
			UiBinder<Widget, TasksSummaryView> {
	}

	public TasksSummaryView() {
		initWidget(uiBinder.createAndBindUi(this));
		
		initCellTable();
	}
	
	private void initCellTable(){
		 // Create name column.
	    TextColumn<Task> titleColumn = new TextColumn<Task>() {
	      @Override
	      public String getValue(Task task) {
	        return task.getTitle();
	      }
	    };

	    // Make the name column sortable.
	    titleColumn.setSortable(true);

	    // Create address column.
	    TextColumn<Task> authorColumn = new TextColumn<Task>() {
	      @Override
	      public String getValue(Task task) {
	        return task.getUser().getUsername();
	      }
	    };

	    // Add the columns.
	    table.addColumn(titleColumn, "Title");
	    table.addColumn(authorColumn, "Author");

	    // Create a data provider.
	    dataProvider = new ListDataProvider<Task>();

	    // Connect the table to the data provider.
	    dataProvider.addDataDisplay(table);

	    // Add the data to the data provider, which automatically pushes it to the
	    // widget.
	    List<Task> list = dataProvider.getList();

        Task t = new Task();
        User u = new User();
        u.setUsername("victor");
        u.setRole("developer");
        t.setUser(u);
	    list.add(t);

	}

	ListDataProvider<Task> dataProvider;
	
	@UiField(provided=true) CellTable<Task> table = new CellTable<Task>();
	@UiField Button button;
	@UiField Button add;

	public void setText(String text) {
		button.setText(text);
	}

	public String getText() {
		return button.getText();
	}

	@UiHandler("button")
	void onButtonClick(ClickEvent event) {
		String url = GWT.getModuleBaseURL() + "service";
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(url));

		try {
		  Request request = builder.sendRequest(null, new RequestCallback() {
		    public void onError(Request request, Throwable exception) {
		      log.warning("Error: "+exception.getMessage());
		    }

			@Override
			public void onResponseReceived(Request request, Response response) {
				 if (200 == response.getStatusCode()) {
			          // Process the response in response.getText()
					 log.fine(response.getText());
			      } else {
			        // Handle the error.  Can get the status text from response.getStatusText()
			    	  log.warning("Status code = " + response.getStatusCode());
			      }
			}
		  });

		} catch (RequestException e) {
		  // Couldn't connect to server
		}
	}
	@UiHandler("add")
	void onAddClick(ClickEvent event) {
	}
}
