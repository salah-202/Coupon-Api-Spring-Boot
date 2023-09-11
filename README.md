# Coupon Service for E-Commerce

## About

The Coupon Service is an integral part of our e-commerce platform, responsible for managing and applying coupon codes during the checkout process. It also maintains a record of coupon usage in the couponHistory table.

## Features

- **Coupon Code Management**: Easily create, list coupons, and use coupon.

- **Discount Rules**: Set up various discount rules such as fixed amount and percentage.

- **Expiration Dates**: Define expiration dates for coupons to create a sense of urgency.

- **Usage Limits**: Control how many times a coupon can be used.

- **Coupon History**: Store a record of coupon usage, including the order ID and usage date.

## Project Structure

The project follows a well-organized structure:

- **Controllers**: Handle incoming HTTP requests and manage coupon-related operations.

- **Services**: Implement business logic, including coupon validation and usage tracking.

- **Repositories**: Interface with the database to perform CRUD operations on coupons and couponHistory.

- **StructMap**: Define data structures and models used throughout the project.

## Database Migrations

Use Liquibase for database schema management. To apply database changes.

## API Documentation with Swagger

The Coupon Service API is documented using Swagger. Access the API documentation and explore endpoints and request/response examples at Swagger UI.
