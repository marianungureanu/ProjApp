/* 
 * Date pt application
 */
use projappdb;

INSERT IGNORE INTO `application` (`id`, `name`, `descr`) VALUES
	(1, 'Engineering Application', 'This application does that and that and also that. It is used to leverage engineering calculations.'),
	(2, 'Banking', 'This application allows banking users to do their online banking actions.'),
	(3, 'Scientific Research', 'This application help researchers to publish their findings and that and that.');

INSERT IGNORE INTO `applicationrole` (`id`, `idrole`, `idapp`) VALUES
	(1, 1, 1),
	(2, 4, 1),
	(3, 7, 2),
	(4, 4, 2),
	(5, 2, 2),
	(6, 4, 3),
	(7, 4, 3);

INSERT IGNORE INTO `applicationroletechnology` (`id`, `idapplicationrole`, `idtechnology`, `idlevel`) VALUES
	(1, 1, 1, 2),
	(2, 1, 2, 3),
	(3, 2, 10, 1),
	(4, 3, 4, 7),
	(5, 4, 4, 2),
	(6, 5, 11, 8),
	(7, 6, 4, 10),
	(8, 7, 10, 2);



