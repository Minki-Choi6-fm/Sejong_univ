-- 1. 학생 테이블 (students)

CREATE TABLE students (
    student_id VARCHAR(10) PRIMARY KEY,		-- student ID
    name VARCHAR(50) NOT NULL,				-- student name
    major VARCHAR(50),	check,				-- student Major
    current_semester INT DEFAULT 1			-- student Current semester
);

-- 2. 과목 테이블 (courses)
CREATE TABLE courses (
    course_code VARCHAR(10) PRIMARY KEY,    -- course_code
    course_name VARCHAR(100) NOT NULL,      -- course_name
    
    department VARCHAR(50) NOT NULL,        -- target_department
    target_year INT NOT NULL,               -- target_year
    
    total_seats INT DEFAULT 0,              -- total seats
    interest_count INT DEFAULT 0            -- interest count
);