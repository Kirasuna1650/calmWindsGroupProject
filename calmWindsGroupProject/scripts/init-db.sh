#!/bin/bash

# This script initializes the database for the Event Booking system.
# It creates the necessary tables and inserts initial data.

# Load the SQL schema
DB_NAME="event_booking_db"
DB_USER="your_db_user"
DB_PASSWORD="your_db_password"

# Create the database if it doesn't exist
echo "Creating database if it doesn't exist..."
mysql -u $DB_USER -p$DB_PASSWORD -e "CREATE DATABASE IF NOT EXISTS $DB_NAME;"

# Apply the schema
echo "Applying schema..."
mysql -u $DB_USER -p$DB_PASSWORD $DB_NAME < ../db/schema.sql

echo "Database initialization complete."