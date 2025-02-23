package br.com.nwl.events.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.nwl.events.dto.SubscriptionRankingItem;
import br.com.nwl.events.model.Event;
import br.com.nwl.events.model.Subscription;
import br.com.nwl.events.model.User;

public interface SubscriptionRepo extends CrudRepository<Subscription, Integer> {
	public Subscription findByEventAndSubscriber(Event evt, User user);
	
	@Query(value = "select count(subscription_number) as quantidade, indication_user_id, user_name"
		       + " from db_events.tbl_subscription inner join db_events.tbl_user"
		       + " on db_events.tbl_subscription.indication_user_id = db_events.tbl_user.user_id"
		       + " where indication_user_id is not null"
		       + " and event_id = :eventId"
		       + " group by indication_user_id, tbl_user.user_name"
		       + " order by quantidade desc", nativeQuery = true)
		public List<SubscriptionRankingItem> generateRanking(@Param("eventId") Integer eventId);

}
