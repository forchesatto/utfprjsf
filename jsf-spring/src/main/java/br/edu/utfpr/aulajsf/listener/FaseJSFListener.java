package br.edu.utfpr.aulajsf.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class FaseJSFListener implements PhaseListener {

	private static final long serialVersionUID = 6702618289917282049L;

	@Override
	public void afterPhase(PhaseEvent event) {
		event.getFacesContext()
				.getExternalContext().log("Depois :"+event.getPhaseId());
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		event.getFacesContext()
		.getExternalContext().log("Antes :"+event.getPhaseId());
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
