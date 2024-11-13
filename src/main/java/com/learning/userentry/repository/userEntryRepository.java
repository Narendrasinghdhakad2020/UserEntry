package com.learning.userentry.repository;

import com.learning.userentry.entity.userEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userEntryRepository extends JpaRepository<userEntry,Long> {
}
